package za.co.wyzetech.cms.workflow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import za.co.wyzetech.cms.workflow.event.EventService;
import za.co.wyzetech.cms.workflow.state.State;
import za.co.wyzetech.cms.workflow.state.StateService;
import za.co.wyzetech.cms.workflow.transition.TransitionService;

@ExtendWith(MockitoExtension.class)
class StateManagerTest {

    @Mock
    private StateService stateService;

    @Mock
    private EventService eventService;

    @Mock
    private TransitionService transitionService;

    private StateManager stateManager;

    @BeforeEach
    void setUp() {
	stateManager = new DefaultStateManager(eventService, stateService, transitionService);
    }

    @Test
    void testCreate() {
	when(stateService.create(any())).thenReturn("1");
	State state = new State();
	String stateRef = stateManager.manageState(state);
	Assertions.assertTrue(Objects.nonNull(stateRef));
    }

}
