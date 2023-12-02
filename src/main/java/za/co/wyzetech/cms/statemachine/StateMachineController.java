package za.co.wyzetech.cms.statemachine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.wyzetech.cms.statemachine.dto.CreateRequest;
import za.co.wyzetech.cms.statemachine.dto.ProcessStateItemRequest;
import za.co.wyzetech.cms.statemachine.dto.ProcessStateItemResponse;
import za.co.wyzetech.cms.statemachine.dto.StateMachineResponse;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;

@RestController
@RequestMapping("/svc/statemachine")
public class StateMachineController {
    private final StateManager stateManager;

    public StateMachineController(StateManager stateManager) {
	this.stateManager = stateManager;
    }

    @PostMapping("/create")
    public ResponseEntity<StateMachineResponse> createManagedState(@RequestBody CreateRequest request) {
	final String externalRef = request.getExternalRef();
	final StateMachineResponse response = new StateMachineResponse();
	StateItem newStateItem = stateManager.createNewStateItem(externalRef);
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
	StateItem newStateItem = stateManager.process(externalRef, action);
	response.setExternalRef(externalRef);
	response.setStateItemId(newStateItem.getId());
	response.setCurrentState(newStateItem.getCurrentState().getName());
	response.setSuccess(true);
	response.setMessage("SUCCESS");
	return ResponseEntity.ok().body(response);
    }
}
