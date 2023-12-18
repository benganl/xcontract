package za.co.wyzetech.smartprocess;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import za.co.wyzetech.smartprocess.common.EventMapper;
import za.co.wyzetech.smartprocess.config.ProcessConfigService;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.event.ProcessEventService;
import za.co.wyzetech.smartprocess.exception.ExternalRefException;
import za.co.wyzetech.smartprocess.process.ProcessService;
import za.co.wyzetech.smartprocess.process.SmartProcess;
import za.co.wyzetech.smartprocess.state.ProcessState;
import za.co.wyzetech.smartprocess.state.ProcessStateService;
import za.co.wyzetech.smartprocess.state.States;

import java.util.Objects;
import java.util.UUID;

@Slf4j
@Component
class DefaultSmartProcessEngine implements SmartProcessEngine {

    private final ProcessService processService;
    private final ProcessStateService processStateService;
    private final ProcessConfigService processConfigService;
    private final ProcessEventService processEventService;
    private final EventMapper eventMapper;

    public DefaultSmartProcessEngine(ProcessStateService processStateService, ProcessService processService,
                                     ProcessConfigService processConfigService, ProcessEventService processEventService, EventMapper eventMapper) {
        this.processStateService = processStateService;
        this.processService = processService;
        this.processConfigService = processConfigService;
        this.processEventService = processEventService;
        this.eventMapper = eventMapper;
    }

    @Override
    public SmartProcess createNewStateItem(String externalRef) {
        if (Objects.isNull(externalRef)) {
            throw new ExternalRefException(2356, "External ref required to create a new process!!!");
        }

        ProcessState newProcessState = processStateService.statusByName(States.NEW.value());

        SmartProcess smartProcess = new SmartProcess();
        smartProcess.setId(UUID.randomUUID());
        smartProcess.setExternalRef(externalRef);
        smartProcess.setCurrentState(newProcessState);
        return processService.create(smartProcess);
    }

    @Override
    public SmartProcess findStateItemById(UUID id) {
        return processService.stateItemById(id);
    }

    @Override
    public void process(String externalRef, String eventName) {
        log.info("Processing for: {}-{}", externalRef, eventName);
        final SmartProcess smartProcess = processService.stateItemByExternalRef(externalRef);
        final ProcessEvent processEvent = processEventService.eventByName(eventName);

        // final ProcessConfig processConfig = processConfigService.nextState(process.getCurrentState(), processEvent);

        /*
        final StateMachineEvent evt = StateMachineEventBuilder
                .init()
                .transition(eventMapper.map(processConfig))
                .stateItem(eventMapper.map(process))
                .build();
         */
        // handler.process(evt);
    }
}
