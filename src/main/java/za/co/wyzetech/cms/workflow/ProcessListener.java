package za.co.wyzetech.cms.workflow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.camunda.bpm.engine.runtime.Execution;
import org.springframework.stereotype.Component;

@Slf4j
@Component("processListener")
public class ProcessListener {

    public void notify(Execution execution) {
        ExecutionEntity executionEntity = (ExecutionEntity) execution;
        String eventName = executionEntity.getEventName();
    }
}
