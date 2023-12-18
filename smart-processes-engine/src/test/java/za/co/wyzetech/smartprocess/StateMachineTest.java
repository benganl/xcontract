package za.co.wyzetech.smartprocess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.wyzetech.smartprocess.common.EventMapper;
import za.co.wyzetech.smartprocess.config.ProcessConfig;
import za.co.wyzetech.smartprocess.config.ProcessConfigService;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.event.ProcessEventService;
import za.co.wyzetech.smartprocess.process.ProcessService;
import za.co.wyzetech.smartprocess.process.SmartProcess;
import za.co.wyzetech.smartprocess.state.ProcessState;
import za.co.wyzetech.smartprocess.state.ProcessStateService;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StateMachineTest {

    @Mock
    private ProcessStateService processStateService;

    @Mock
    private ProcessService processService;

    @Mock
    private ProcessEventService processEventService;

    @Mock
    private ProcessConfigService processConfigService;

    @Mock
    private EventMapper eventMapper;

    private SmartProcessEngine smartProcessEngine;

    @BeforeEach
    void setUp() {
        // MockitoAnnotations.openMocks(this);
        smartProcessEngine = new DefaultSmartProcessEngine(processStateService, processService, processConfigService, processEventService, eventMapper);
    }

    @Test
    void testCreateStateItem() {
        when(processStateService.statusByName("NEW")).thenReturn(processState("NEW"));
        when(processService.create(any())).thenReturn(process());
        SmartProcess smartProcess = smartProcessEngine.createNewStateItem("1");

        Assertions.assertTrue(Objects.nonNull(smartProcess));
        Assertions.assertEquals("1", smartProcess.getExternalRef());
        Assertions.assertEquals(processState("NEW"), smartProcess.getCurrentState());
    }

    @Test
    void testFindStateItem() {
        when(processService.stateItemById(any())).thenReturn(process());
        SmartProcess smartProcess = smartProcessEngine.findStateItemById(UUID.randomUUID());
        Assertions.assertTrue(Objects.nonNull(smartProcess));
        Assertions.assertEquals("1", smartProcess.getExternalRef());
    }

    @Test
    void testTransitionStateItem() {
        when(processService.stateItemById(any())).thenReturn(process());
        when(processEventService.eventByName(any())).thenReturn(processEvent("PROCESS"));
        when(processConfigService.nextState(any(), any())).thenReturn(processConfig());
        when(processService.stateItemByExternalRef(any())).thenReturn(process());

        SmartProcess smartProcess = smartProcessEngine.findStateItemById(UUID.randomUUID());
        ProcessEvent processEvent = processEventService.eventByName("PROCESS");

        smartProcessEngine.process("1", "COMPLETE");

        Assertions.assertEquals("1", smartProcess.getExternalRef());
    }

    private ProcessEvent processEvent(String name) {
        ProcessEvent processEvent = new ProcessEvent();
        processEvent.setId(UUID.randomUUID());
        processEvent.setName(name);
        processEvent.setDescription(String.format("%s description", name));
        return processEvent;
    }

    private SmartProcess process() {
        SmartProcess smartProcess = new SmartProcess();
        smartProcess.setCurrentState(processState("NEW"));
        smartProcess.setExternalRef("1");
        smartProcess.setId(UUID.randomUUID());
        return smartProcess;
    }

    private ProcessState processState(String name) {
        ProcessState processState = new ProcessState();
        processState.setId(UUID.randomUUID());
        processState.setName(name);
        processState.setDescription(String.format("%s Status", name));
        processState.setCreateDate(new Date());
        processState.setStartDate(new Date());
        processState.setEndDate(new Date());
        return processState;
    }

    private ProcessConfig processConfig() {
        ProcessConfig processConfig = new ProcessConfig();
        processConfig.setId(UUID.randomUUID());
        processConfig.setCurrentState(processState("NEW"));
        processConfig.setNextState(processState("PROCESSING"));
        // processConfig.setEvent(processEvent("PROCESS"));
        return processConfig;
    }
}
