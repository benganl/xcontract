package za.co.wyzetech.smartprocess.process;

import java.util.UUID;

import reactor.core.publisher.Mono;

public interface SmartProcessService {

    Mono<SmartProcess> findSmartProcessById(UUID id);

    Mono<SmartProcess> create(String externalRef);

    Mono<SmartProcess> smartProcessByExternalRef(String externalRef);

}
