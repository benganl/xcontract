package za.co.wyzetech.cms.statemachine.config;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

public interface StateConfigService {

    StateConfig nextState(State currentState, Event event);

}
