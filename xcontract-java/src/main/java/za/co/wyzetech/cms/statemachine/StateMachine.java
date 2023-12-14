package za.co.wyzetech.cms.statemachine;

import java.util.UUID;

import za.co.wyzetech.cms.statemachine.stateitem.StateItem;

public interface StateMachine {
    StateItem createNewStateItem(String externalRef);

    StateItem findStateItemById(UUID randomUUID);

    void process(String externalRef, String action);
}
