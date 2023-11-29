package za.co.wyzetech.cms.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.repository.ContractRepository;
import za.co.wyzetech.cms.util.JsonUtil;
import za.co.wyzetech.cms.validator.ContractValidator;
import za.co.wyzetech.cms.workflow.Workflow;
import za.co.wyzetech.cms.workflow.Workflow;

@Component("contractWorker")
public class ContractWorker {
    private final Workflow workflow;
    private final ContractService contractService;
    private final ContractValidator contractValidator;
    private final ContractRepository contractRepository;
    private final JsonUtil jsonUtil;

    public ContractWorker(Workflow workflow, ContractService contractService, ContractValidator contractValidator,
	    ContractRepository contractRepository, JsonUtil jsonUtil) {
	this.workflow = workflow;
	this.contractService = contractService;
	this.contractValidator = contractValidator;
	this.contractRepository = contractRepository;
	this.jsonUtil = jsonUtil;
    }

    public void createNewContract(Contract contract) {
	workflow.createProcess(contract);
    }

    public void saveContractToDatabase(Object command) {
	Workflow state = workflow.getState(command);
	Contract contract = jsonUtil.fromJson(state.getPayload(), Contract.class);
	// contract.setId(UUID.fromString(state.getBusinessKey()));
	contractRepository.save(contract);
    }

    public List<String> validate(Contract contract) {
	return contractValidator.validate(contract);
    }
}
