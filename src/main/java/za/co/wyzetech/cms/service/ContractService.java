package za.co.wyzetech.cms.service;

import org.springframework.stereotype.Service;
import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.repository.ContractRepository;
import za.co.wyzetech.cms.validator.ContractValidator;
import za.co.wyzetech.cms.workflow.Workflow;

import java.util.List;

@Service("contractService")
public class ContractService {

    private final Workflow workflow;
    private final ContractValidator contractValidator;
    private final ContractRepository contractRepository;

    public ContractService(Workflow workflow, ContractValidator contractValidator, ContractRepository contractRepository) {
        this.workflow = workflow;
        this.contractValidator = contractValidator;
        this.contractRepository = contractRepository;
    }

    public void createNewContract(Contract contract) {
        workflow.createProcess(contract);
    }

    public List<String> validate(Contract contract) {
        return contractValidator.validate(contract);
    }
}
