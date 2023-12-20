package za.co.wyzetech.smartprocess.state;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface ProcessStateRepository extends ReactiveCrudRepository<ProcessState, UUID> {

    ProcessState findByName(String name);

}
