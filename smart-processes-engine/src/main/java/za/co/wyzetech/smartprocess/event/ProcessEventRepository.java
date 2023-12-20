package za.co.wyzetech.smartprocess.event;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProcessEventRepository extends ReactiveCrudRepository<ProcessEvent, UUID> {

    ProcessEvent findByName(String name);

}
