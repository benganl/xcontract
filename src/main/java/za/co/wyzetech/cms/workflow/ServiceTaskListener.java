package za.co.wyzetech.cms.workflow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.impl.persistence.entity.ProcessInstanceWithVariablesImpl;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service("serviceTaskListener")
public class ServiceTaskListener {
    public void notify(Object command) {
        String id = null;
        if (command instanceof Execution) {
            ExecutionEntity execution = (ExecutionEntity) command;
            String activityId = execution.getActivityId();
            switch (activityId) {
                case "UNPACK_PAYLOAD":
                    System.out.println("UNPACK_PAYLOAD");
                    break;
                case "VALIDATE_PAYLOAD":
                    execution.setVariable("isValidPayload", false);
                    System.out.println("VALIDATE_PAYLOAD");
                    break;
                case "HANDLE_PAYLOAD_EXCEPTION":
                    System.out.println("HANDLE_PAYLOAD_EXCEPTION");
                    break;
                default:
                    System.out.println("Unknown activity!!!");
                    break;
            }
            // activityProcessor.processTask(activityId, execution);
            log.info("Execution[{}]", id);
        } else if (command instanceof ProcessInstance) {
            ProcessInstanceWithVariablesImpl processInstance = (ProcessInstanceWithVariablesImpl) command;
            id = processInstance.getBusinessKey();
            log.info("ProcessInstance[{}]", id);
        } else {
            log.error("Something wrong here....");
            Class<?>[] interfaces = command.getClass().getInterfaces();
            Arrays.stream(interfaces).forEach(System.out::println);
            log.info(":::::::::::::::::: ServiceTaskListener (Custom) ::::::::::::::::::");
        }
    }
}
