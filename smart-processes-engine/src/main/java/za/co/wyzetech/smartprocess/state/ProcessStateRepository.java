package za.co.wyzetech.smartprocess.state;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProcessStateRepository extends JpaRepository<ProcessState, UUID> {

    ProcessState findByName(String name);

}
