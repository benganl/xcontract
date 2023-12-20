package za.co.wyzetech.smartprocess.config;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.state.ProcessState;

interface ProcessConfigRepository extends ReactiveCrudRepository<ProcessConfig, UUID> {
    ProcessConfig findByCurrentStateAndProcessEvent(ProcessState currentState, ProcessEvent processEvent);
}
