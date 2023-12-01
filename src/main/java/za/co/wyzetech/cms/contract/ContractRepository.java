package za.co.wyzetech.cms.contract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.contract.model.Contract;

interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> getContractsByPartiesId(Long partyId);
}
