package za.co.wyzetech.cms.service;

import org.camunda.bpm.engine.ExternalTaskService;
import org.springframework.stereotype.Service;
import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.repository.ContractRepository;
import za.co.wyzetech.cms.util.JsonUtil;
import za.co.wyzetech.cms.validator.ContractValidator;
import za.co.wyzetech.cms.workflow.Workflow;
import za.co.wyzetech.cms.workflow.WorkflowState;

import java.util.List;
import java.util.UUID;

@Service("contractService")
public class ContractService {

    private final Workflow workflow;
    private final ContractValidator contractValidator;
    private final ContractRepository contractRepository;
    private final JsonUtil jsonUtil;

    public ContractService(Workflow workflow, ContractValidator contractValidator, ContractRepository contractRepository, JsonUtil jsonUtil) {
        this.workflow = workflow;
        this.contractValidator = contractValidator;
        this.contractRepository = contractRepository;
        this.jsonUtil = jsonUtil;
    }

    public void createNewContract(Contract contract) {
        workflow.createProcess(contract);
    }

    public List<String> validate(Contract contract) {
        return contractValidator.validate(contract);
    }

    public void process(Object command) {
        WorkflowState state = workflow.getState(command);
        Contract contract = jsonUtil.fromJson(state.getPayload(), Contract.class);
        // contract.setId(UUID.fromString(state.getBusinessKey()));
        // contractRepository.save(contract);
    }
}
