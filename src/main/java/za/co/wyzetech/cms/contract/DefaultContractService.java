package za.co.wyzetech.cms.contract;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.contract.model.Contract;
import za.co.wyzetech.cms.statemachine.StateMachine;

@Slf4j
@Service
class DefaultContractService implements ContractService {

    private final ContractRepository contractRepository;
    private final StateMachine stateManager;

    public DefaultContractService(ContractRepository contractRepository, StateMachine stateManager) {
	this.contractRepository = contractRepository;
	this.stateManager = stateManager;
    }

    public List<String> validate(Contract contract) {
	List<String> validationErrors = new ArrayList<>();
	return validationErrors;
    }

    @Override
    public void create(Contract contract) {
	var managed = contractRepository.save(contract);
    }
}
