package za.co.wyzetech.cms.workflow;

import org.springframework.stereotype.Component;

import za.co.wyzetech.cms.workflow.event.EventService;
import za.co.wyzetech.cms.workflow.state.State;
import za.co.wyzetech.cms.workflow.state.StateService;
import za.co.wyzetech.cms.workflow.transition.TransitionService;

@Component
class DefaultStateManager implements StateManager {

    private final EventService eventService;
    private final StateService stateService;
    private final TransitionService transitionService;

    public DefaultStateManager(EventService eventService, StateService stateService, TransitionService transitionService) {
	this.eventService = eventService;
	this.stateService = stateService;
	this.transitionService = transitionService;
    }

    @Override
    public void start() {
	State state = stateService.newState();
    }

    @Override
    public String manageState(State state) {
	return stateService.create(state);
    }
}
