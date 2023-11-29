package za.co.wyzetech.cms.workflow;

import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class Workflow {

    public static final String PROCESS_ENGINE_ID = "cmsProcess";

    public static final  String PAYLOAD = "payload";
    public static final String OBJECT_ID = "id";
    public static final String VALIDATED = "validated";

    private final ProcessEngine processEngine;
    private final ExternalTaskService externalTaskService;
    private final JsonUtil jsonUtil;

    @Autowired
    public Workflow(ProcessEngine processEngine, ExternalTaskService externalTaskService, JsonUtil jsonUtil) {
        this.processEngine = processEngine;
        this.externalTaskService = externalTaskService;
        this.jsonUtil = jsonUtil;
    }

    public void createProcess(Contract contract) {
        Map<String, Object> variables = new HashMap<>();
        String objectID = UUID.randomUUID().toString();

        variables.put(PAYLOAD, jsonUtil.toJson(contract));
        variables.put(OBJECT_ID, objectID);
        variables.put(VALIDATED, false);

        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstanceWithVariables instance = runtimeService
                .createProcessInstanceByKey(PROCESS_ENGINE_ID)
                .businessKey(objectID)
                .setVariables(variables)
                .executeWithVariablesInReturn();
    }

    public WorkflowState getState(Object command) {
        ExecutionEntity execution = (ExecutionEntity) command;
        String payload = String.valueOf(execution.getVariable(Workflow.PAYLOAD));
        String businessKey = execution.getBusinessKey();
        String processId = execution.getProcessInstanceId();
        return new WorkflowState(payload, businessKey, processId);
    }

    public void complete(Object command) {
        ExecutionEntity execution = (ExecutionEntity) command;
        String payload = String.valueOf(execution.getVariable(Workflow.PAYLOAD));
        String businessKey = execution.getBusinessKey();
        String processId = execution.getProcessInstanceId();
        //TaskService taskService = processEngine.g
        // taskService.complete(taskId);
    }
}