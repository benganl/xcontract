package za.co.wyzetech.cms.contract;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.contract.model.Contract;

interface ContractRepository extends JpaRepository<Contract, Long> {

    List<Contract> getContractsByPartyId(Long partyId);

    List<Contract> getContracts(Date startDate, Date endDate);
}
