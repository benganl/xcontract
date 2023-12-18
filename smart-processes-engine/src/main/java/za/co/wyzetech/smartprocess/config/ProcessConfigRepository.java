package za.co.wyzetech.smartprocess.config;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.state.ProcessState;

import java.util.UUID;

interface ProcessConfigRepository extends JpaRepository<ProcessConfig, UUID> {
    ProcessConfig findByCurrentStateAndEvent(ProcessState currentState, ProcessEvent processEvent);
}
