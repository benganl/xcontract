package za.co.wyzetech.cms.statemachine;

import org.springframework.stereotype.Component;

import za.co.wyzetech.cms.statemachine.stateitem.StateItem;
import za.co.wyzetech.cms.statemachine.stateitem.StateItemFactory;

@Component
class DefaultStateManager implements StateManager {

    @Override
    public String init() {
	StateItem stateItem = StateItemFactory.create();
	return null; // stateService.create(stateItem);
    }
}
