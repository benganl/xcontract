package za.co.wyzetech.cms.statemachine;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import za.co.wyzetech.cms.statemachine.common.EventMapper;
import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.event.EventService;
import za.co.wyzetech.cms.statemachine.event.handler.StateMachineEventHandler;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.state.StateService;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.stateitem.StateItemService;
import za.co.wyzetech.cms.statemachine.transition.Transition;
import za.co.wyzetech.cms.statemachine.transition.TransitionService;

@ExtendWith(MockitoExtension.class)
class StateMachineTest {

    @Mock
    private StateService stateService;

    @Mock
    private StateItemService stateItemService;

    @Mock
    private EventService eventService;

    @Mock
    private TransitionService transitionService;

    @Mock
    private StateMachineEventHandler handler;

    @Mock
    private EventMapper eventMapper;

    private StateMachine stateMachine;

    @BeforeEach
    void setUp() {
	// MockitoAnnotations.openMocks(this);
	stateMachine = new DefaultStateMachine(stateService, stateItemService, transitionService, eventService, handler,
		eventMapper);
    }

    @Test
	void testCreateStateItem() {
		when(stateService.statusByName("NEW")).thenReturn(state("NEW"));
		when(stateItemService.create(any())).thenReturn(stateItem());
		StateItem stateItem = stateMachine.createNewStateItem("1");

		Assertions.assertTrue(Objects.nonNull(stateItem));
		Assertions.assertEquals("1", stateItem.getExternalRef());
		Assertions.assertEquals(state("NEW"), stateItem.getCurrentState());
	}

    @Test
	void testFindStateItem() {
		when(stateItemService.stateItemById(any())).thenReturn(stateItem());
		StateItem stateItem = stateMachine.findStateItemById(UUID.randomUUID());
		Assertions.assertTrue(Objects.nonNull(stateItem));
		Assertions.assertEquals("1", stateItem.getExternalRef());
	}

    @Test
	void testTransitionStateItem() {
		when(stateItemService.stateItemById(any())).thenReturn(stateItem());
		when(eventService.eventByName(any())).thenReturn(event("PROCESS"));
		when(transitionService.nextState(any(), any())).thenReturn(transition());
		when(stateItemService.stateItemByExternalRef(any())).thenReturn(stateItem());

		StateItem stateItem = stateMachine.findStateItemById(UUID.randomUUID());
		Event event = eventService.eventByName("PROCESS");

		stateMachine.process("1", "COMPLETE");

		Assertions.assertEquals("1", stateItem.getExternalRef());
	}

    private Event event(String name) {
	Event event = new Event();
	event.setId(UUID.randomUUID());
	event.setName(name);
	event.setDescription(String.format("%s description", name));
	return event;
    }

    private StateItem stateItem() {
	StateItem stateItem = new StateItem();
	stateItem.setCurrentState(state("NEW"));
	stateItem.setExternalRef("1");
	stateItem.setId(UUID.randomUUID());
	return stateItem;
    }

    private State state(String name) {
	State state = new State();
	state.setId(UUID.randomUUID());
	state.setName(name);
	state.setDescription(String.format("%s Status", name));
	state.setCreateDate(new Date());
	state.setStartDate(new Date());
	state.setEndDate(new Date());
	return state;
    }

    private Transition transition() {
	Transition transition = new Transition();
	transition.setId(UUID.randomUUID());
	transition.setCurrentState(state("NEW"));
	transition.setNextState(state("PROCESSING"));
	transition.setEvent(event("PROCESS"));
	return transition;
    }
}
