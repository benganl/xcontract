package za.co.wyzetech.cms.workflow;

import za.co.wyzetech.cms.workflow.state.State;

public interface StateManager {

    void start();

    String manageState(State state);

}
