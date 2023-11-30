package za.co.wyzetech.cms.contract;

import java.util.List;

import za.co.wyzetech.cms.contract.model.Contract;

public interface ContractService {

    public List<String> validate(Contract contract);

    public void create(Contract contract);
}
