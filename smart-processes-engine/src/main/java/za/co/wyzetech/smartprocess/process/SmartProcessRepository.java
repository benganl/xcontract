package za.co.wyzetech.smartprocess.process;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

interface SmartProcessRepository extends ReactiveCrudRepository<SmartProcess, UUID> {
    Mono<SmartProcess> getById(UUID id);

    Mono<SmartProcess> findByExternalRef(String externalRef);
}
