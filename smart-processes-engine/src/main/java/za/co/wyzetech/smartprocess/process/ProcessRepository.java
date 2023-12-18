package za.co.wyzetech.smartprocess.process;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface ProcessRepository extends JpaRepository<SmartProcess, UUID> {
    SmartProcess getById(UUID id);

    SmartProcess findByExternalRef(String externalRef);
}
