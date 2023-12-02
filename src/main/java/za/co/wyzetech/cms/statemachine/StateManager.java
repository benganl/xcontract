package za.co.wyzetech.cms.statemachine;

import java.util.UUID;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;

public interface StateManager {
    StateItem createNewStateItem(String externalRef);

    StateItem findStateItemById(UUID randomUUID);

    State nextState(StateItem stateItem, Event event);
}
