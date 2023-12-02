package za.co.wyzetech.cms.contract;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.contract.model.Contract;

interface ContractRepository extends JpaRepository<Contract, UUID> {

    List<Contract> getContractsByPartiesId(UUID partyId);
}
