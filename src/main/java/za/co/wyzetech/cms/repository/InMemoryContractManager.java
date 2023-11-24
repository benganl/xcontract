package za.co.wyzetech.cms.repository;

import za.co.wyzetech.cms.model.Contract;

import java.util.*;

public class InMemoryContractManager implements ContractRepository {

    private final Map<UUID, Contract> contractDB = new HashMap<>();

    @Override
    public List<Contract> getContractsByPartyId(Long partyId) {
        return null;
    }

    @Override
    public List<Contract> getContracts(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Contract getContractById(Long contractId) {
        return null;
    }

    @Override
    public void createContract(Contract contract) {

    }

    @Override
    public void updateContract(Contract contract) {

    }

    @Override
    public void deleteContract(Long contractId) {

    }
}
