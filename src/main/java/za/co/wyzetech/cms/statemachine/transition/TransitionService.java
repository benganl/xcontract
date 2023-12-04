package za.co.wyzetech.cms.statemachine.transition;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

public interface TransitionService {

    Transition nextState(State currentState, Event event);

}
