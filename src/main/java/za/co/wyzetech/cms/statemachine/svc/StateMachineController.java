package za.co.wyzetech.cms.statemachine.svc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.wyzetech.cms.statemachine.StateMachine;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.svc.dto.ProcessStateItemRequest;
import za.co.wyzetech.cms.statemachine.svc.dto.ProcessStateItemResponse;
import za.co.wyzetech.cms.statemachine.svc.dto.StateMachineRequest;
import za.co.wyzetech.cms.statemachine.svc.dto.StateMachineResponse;

@RestController
@RequestMapping("/svc/statemachine")
public class StateMachineController {
    private final StateMachine stateMachine;

    public StateMachineController(StateMachine stateMachine) {
	this.stateMachine = stateMachine;
    }

    @PostMapping("/create")
    public ResponseEntity<StateMachineResponse> createManagedState(@RequestBody StateMachineRequest request) {
	final String externalRef = request.getExternalRef();
	final StateMachineResponse response = new StateMachineResponse();
	StateItem newStateItem = stateMachine.createNewStateItem(externalRef);
	response.setExternalRef(externalRef);
	response.setStateItemId(newStateItem.getId());
	response.setSuccess(true);
	response.setMessage("SUCCESS");
	return ResponseEntity.ok().body(response);
    }

    @PostMapping("/process")
    public ResponseEntity<ProcessStateItemResponse> process(@RequestBody ProcessStateItemRequest request) {
	final String externalRef = request.getExternalRef();
	final String action = request.getAction();

	final ProcessStateItemResponse response = new ProcessStateItemResponse();
	stateMachine.process(externalRef, action);

	response.setExternalRef(externalRef);
	// response.setStateItemId(newStateItem.getId());
	// response.setCurrentState(newStateItem.getCurrentState().getName());
	response.setSuccess(true);
	response.setMessage("SUCCESS");

	return ResponseEntity.ok().body(response);
    }
}
