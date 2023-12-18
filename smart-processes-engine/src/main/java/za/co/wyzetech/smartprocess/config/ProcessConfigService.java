package za.co.wyzetech.smartprocess.config;

import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.state.ProcessState;

public interface ProcessConfigService {

    ProcessConfig nextState(ProcessState currentState, ProcessEvent processEvent);

}
