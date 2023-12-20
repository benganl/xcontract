package za.co.wyzetech.smartprocess.svc;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import za.co.wyzetech.smartprocess.SmartProcessEngine;
import za.co.wyzetech.smartprocess.process.SmartProcess;
import za.co.wyzetech.smartprocess.svc.dto.ProcessStateItemRequest;
import za.co.wyzetech.smartprocess.svc.dto.ProcessStateItemResponse;
import za.co.wyzetech.smartprocess.svc.dto.StateMachineRequest;
import za.co.wyzetech.smartprocess.svc.dto.StateMachineResponse;

@RestController
@RequestMapping("/svc/statemachine")
public class StateMachineController {
    private final SmartProcessEngine smartProcessEngine;

    public StateMachineController(SmartProcessEngine smartProcessEngine) {
	this.smartProcessEngine = smartProcessEngine;
    }

    @PostMapping("/{externalRef}")
    public Mono<SmartProcess> findByExternal(@PathVariable("externalRef") String externlRef,
	    @RequestBody StateMachineRequest request) {
	final String externalRef = request.getExternalRef();
	final StateMachineResponse response = new StateMachineResponse();

	return smartProcessEngine.findSmartProcessByExternalRef(externlRef);
    }

    @PostMapping("/create")
    public ResponseEntity<StateMachineResponse> createManagedState(@RequestBody StateMachineRequest request) {
	final String externalRef = request.getExternalRef();
	final StateMachineResponse response = new StateMachineResponse();
	smartProcessEngine.createNewSmartProcess(externalRef);
	response.setExternalRef(externalRef);
	// response.setStateItemId(newStateItem.getId());
	response.setSuccess(true);
	response.setMessage("SUCCESS");
	return ResponseEntity.ok().body(response);
    }

    @PostMapping("/process")
    public ResponseEntity<ProcessStateItemResponse> process(@RequestBody ProcessStateItemRequest request) {
	final String externalRef = request.getExternalRef();
	final String action = request.getAction();

	final ProcessStateItemResponse response = new ProcessStateItemResponse();
	smartProcessEngine.process(externalRef, action);

	response.setExternalRef(externalRef);
	// response.setStateItemId(newStateItem.getId());
	// response.setCurrentState(newStateItem.getCurrentState().getName());
	response.setSuccess(true);
	response.setMessage("SUCCESS");

	return ResponseEntity.ok().body(response);
    }
}
