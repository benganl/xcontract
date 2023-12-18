package za.co.wyzetech.smartprocess.config;

import org.springframework.stereotype.Service;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.state.ProcessState;

@Service
class DefaultProcessConfigService implements ProcessConfigService {
    private final ProcessConfigRepository processConfigRepository;

    public DefaultProcessConfigService(ProcessConfigRepository processConfigRepository) {
        this.processConfigRepository = processConfigRepository;
    }

    @Override
    public ProcessConfig nextState(ProcessState currentState, ProcessEvent processEvent) {
        ProcessConfig processConfig = processConfigRepository.findByCurrentStateAndEvent(currentState, processEvent);
        return processConfig;
    }
}
