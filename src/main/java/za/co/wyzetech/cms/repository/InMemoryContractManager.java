package za.co.wyzetech.cms.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import za.co.wyzetech.cms.model.Contract;

@Repository
// @Profile({"dev", "dev-test"})
public class InMemoryContractManager implements ContractRepository {

    private final List<Contract> contractDB = new ArrayList<>();

    @Override
    public void save(Contract contract) {
	if (contractDB.contains(contract)) {
	    contractDB.remove(contract);
	}
	contractDB.add(contract);
    }

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
    public void updateContract(Contract contract) {

    }

    @Override
    public void deleteContract(Long contractId) {

    }
}
