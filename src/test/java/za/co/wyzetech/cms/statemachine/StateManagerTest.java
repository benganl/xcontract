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

import za.co.wyzetech.cms.statemachine.config.StateConfig;
import za.co.wyzetech.cms.statemachine.config.StateConfigService;
import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.event.EventService;
import za.co.wyzetech.cms.statemachine.state.State;
import za.co.wyzetech.cms.statemachine.state.StateService;
import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.stateitem.StateItemService;

@ExtendWith(MockitoExtension.class)
class StateManagerTest {

	@Mock
	private StateService stateService;

	@Mock
	private StateItemService stateItemService;

	@Mock
	private EventService eventService;

	@Mock
	private StateConfigService stateConfigService;

	private StateManager stateManager;

	@BeforeEach
	void setUp() {
		stateManager = new DefaultStateManager(stateService, stateItemService, stateConfigService, eventService);
	}

	@Test
	void testCreateStateItem() {
		when(stateService.statusByName("NEW")).thenReturn(state("NEW"));
		StateItem stateItem = stateManager.createNewStateItem("1");

		Assertions.assertTrue(Objects.nonNull(stateItem));
		Assertions.assertEquals("1", stateItem.getExternalRef());
		Assertions.assertEquals(state("NEW"), stateItem.getCurrentState());
	}

	@Test
	void testFindStateItem() {
		when(stateItemService.stateItemById(any())).thenReturn(stateItem());
		StateItem stateItem = stateManager.findStateItemById(UUID.randomUUID());
		Assertions.assertTrue(Objects.nonNull(stateItem));
		Assertions.assertEquals("1", stateItem.getExternalRef());
	}

	@Test
	void testTransitionStateItem() {
		when(stateItemService.stateItemById(any())).thenReturn(stateItem());
		when(eventService.eventByName(any())).thenReturn(event("PROCESS"));
		when(stateConfigService.nextState(any(), any())).thenReturn(stateConfig());

		StateItem stateItem = stateManager.findStateItemById(UUID.randomUUID());
		Event event = eventService.eventByName("PROCESS");

		State state = stateManager.nextState(stateItem, event);

		Assertions.assertNotNull(state);
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

	private StateConfig stateConfig() {
		StateConfig stateConfig = new StateConfig();
		stateConfig.setId(UUID.randomUUID());
		stateConfig.setCurrentState(state("NEW"));
		stateConfig.setNextState(state("PROCESSING"));
		stateConfig.setEvent(event("PROCESS"));
		return stateConfig;
	}
}
