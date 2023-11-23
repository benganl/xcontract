package za.co.wyzetech.cms.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

@Slf4j
@Component("taskListener")
public class TaskListener implements org.camunda.bpm.engine.delegate.TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        log.info(":::::::::::::::::: Task Listener ::::::::::::::::::");
    }
}
