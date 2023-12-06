package za.co.wyzetech.cms.statemachine;

import java.util.UUID;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.statemachine.common.EventMapper;
import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.event.EventService;
import za.co.wyzetech.cms.statemachine.event.handler.StateMachineEvent;
import za.co.wyzetech.cms.statemachine.event.handler.StateMachineEventBuilder;
import za.co.wyzetech.cms.statemachine.event.handler.StateMachineEventHandler;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.state.StateService;
import za.co.wyzetech.cms.statemachine.state.States;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.stateitem.StateItemService;
import za.co.wyzetech.cms.statemachine.transition.Transition;
import za.co.wyzetech.cms.statemachine.transition.TransitionService;

@Slf4j
@Component
class DefaultStateMachine implements StateMachine {

    private final StateService stateService;
    private final StateItemService stateItemService;
    private final TransitionService transitionService;
    private final EventService eventService;
    private final StateMachineEventHandler handler;
    private final EventMapper eventMapper;

    public DefaultStateMachine(StateService stateService, StateItemService stateItemService,
	    TransitionService transitionService, EventService eventService, StateMachineEventHandler handler,
	    EventMapper eventMapper) {
	this.stateService = stateService;
	this.stateItemService = stateItemService;
	this.transitionService = transitionService;
	this.eventService = eventService;
	this.handler = handler;
	this.eventMapper = eventMapper;
    }

    @Override
    public StateItem createNewStateItem(String externalRef) {
	State newState = stateService.statusByName(States.NEW.value());
	StateItem stateItem = new StateItem();
	stateItem.setId(UUID.randomUUID());
	stateItem.setExternalRef(externalRef);
	stateItem.setCurrentState(newState);
	return stateItemService.create(stateItem);
    }

    @Override
    public StateItem findStateItemById(UUID id) {
	return stateItemService.stateItemById(id);
    }

    @Override
    public void process(String externalRef, String eventName) {
	log.info("Processing for: {}-{}", externalRef, eventName);
	final StateItem stateItem = stateItemService.stateItemByExternalRef(externalRef);
	final Event event = eventService.eventByName(eventName);

	final Transition transition = transitionService.nextState(stateItem.getCurrentState(), event);

	final StateMachineEvent evt = StateMachineEventBuilder
		.init()
		.transition(eventMapper.map(transition))
		.stateItem(eventMapper.map(stateItem))
		.build();

	handler.process(evt);
    }
}
