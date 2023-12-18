package za.co.wyzetech.smartprocess.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProcessEventRepository extends JpaRepository<ProcessEvent, UUID> {

    ProcessEvent findByName(String name);

}
