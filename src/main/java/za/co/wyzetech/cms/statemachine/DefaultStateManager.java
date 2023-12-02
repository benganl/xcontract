package za.co.wyzetech.cms.statemachine;

import java.util.UUID;

import org.springframework.stereotype.Component;

import za.co.wyzetech.cms.statemachine.config.StateConfig;
import za.co.wyzetech.cms.statemachine.config.StateConfigService;
import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.event.EventService;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.state.StateService;
import za.co.wyzetech.cms.statemachine.state.States;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.stateitem.StateItemService;

@Component
class DefaultStateManager implements StateManager {

    private final StateService stateService;
    private final StateItemService stateItemService;
    private final StateConfigService stateConfigService;
    private final EventService eventService;

    public DefaultStateManager(StateService stateService, StateItemService stateItemService,
	    StateConfigService stateConfigService, EventService eventService) {
	this.stateService = stateService;
	this.stateItemService = stateItemService;
	this.stateConfigService = stateConfigService;
	this.eventService = eventService;
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
    public State process(StateItem stateItem, Event event) {
	State currentState = stateItem.getCurrentState();
	StateConfig stateConfig = stateConfigService.nextState(currentState, event);
	return stateConfig.getNextState();
    }

    @Override
    public StateItem process(String externalRef, String eventName) {
	final StateItem stateItem = stateItemService.stateItemByExternalRef(externalRef);
	final Event event = eventService.eventByName(eventName);
	final StateConfig stateConfig = stateConfigService.nextState(stateItem.getCurrentState(), event);
	
	stateItem.setCurrentState(stateConfig.getNextState());
	
	return stateItem;
    }
}
