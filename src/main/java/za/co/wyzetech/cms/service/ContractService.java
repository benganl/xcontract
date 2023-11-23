package za.co.wyzetech.cms.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.model.ContractStatus;

public class ContractService implements JavaDelegate {

    @Override
    public void execute(DelegateExecution context) throws Exception {

    }

    public void createNewContract(Contract contract) {
        if (ContractStatus.NEW.equals(contract.getStatus())) {
            contract.setStatus(ContractStatus.NEGOTIATION);
            System.out.println("Contract submitted for negotiation.");
        } else {
            System.out.println("Contract is not in draft status.");
        }
    }

    public void updateContract(Contract contract, ContractStatus status) {
        if (contract.getStatus() == ContractStatus.NEGOTIATION) {
            System.out.println("Negotiating the validator...");
        } else {
            System.out.println("Cannot negotiate. Contract is not in negotiation status.");
        }
    }

    public void finalizeNegotiation(Contract contract) {
        if (contract.getStatus() == ContractStatus.NEGOTIATION) {
            contract.setStatus(ContractStatus.REVIEW);
            System.out.println("Negotiation finalized. Contract moved to review stage.");
        } else {
            System.out.println("Cannot finalize negotiation. Contract is not in negotiation status.");
        }
    }

    public void approveContract(Contract contract) {
        if (contract.getStatus() == ContractStatus.REVIEW) {
            contract.setStatus(ContractStatus.APPROVED);
            System.out.println("Contract approved.");
        } else {
            System.out.println("Cannot approve. Contract is not in review status.");
        }
    }
}
