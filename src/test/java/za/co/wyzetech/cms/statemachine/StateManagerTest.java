package za.co.wyzetech.cms.statemachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StateManagerTest {

    private StateManager stateManager;

    @BeforeEach
    void setUp() {
	stateManager = Mockito.mock(DefaultStateManager.class);
    }

    @Test
    void testStateTransition() {
	// when(stateService.create(any())).thenReturn("1");
	// State state = new State();
	// String stateRef = stateManager.init();
	// Assertions.assertTrue(Objects.nonNull(stateRef));
    }
}
