package za.co.wyzetech.smartprocess;

import java.util.UUID;

import reactor.core.publisher.Mono;
import za.co.wyzetech.smartprocess.process.SmartProcess;

public interface SmartProcessEngine {
    Mono<SmartProcess> createNewSmartProcess(String externalRef);

    Mono<SmartProcess> findSmartProcessById(UUID randomUUID);

    Mono<SmartProcess> findSmartProcessByExternalRef(String externalRef);

    void process(String externalRef, String action);
}
