package za.co.wyzetech.cms.repository;

import za.co.wyzetech.cms.model.Contract;

import java.util.Date;
import java.util.List;

public interface ContractRepository {

    List<Contract> getContractsByPartyId(Long partyId);
    List<Contract> getContracts(Date startDate, Date endDate);
    Contract getContractById(Long contractId);

    void updateContract(Contract contract);
    void deleteContract(Long contractId);

    void save(Contract contract);
}
