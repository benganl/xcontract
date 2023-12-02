package za.co.wyzetech.cms.statemachine.stateitem;

import java.util.UUID;

class DefaultStateItemService implements StateItemService {

    private StateItemRepository stateItemRepository;

    @Override
    public StateItem stateItemById(UUID id) {
	return stateItemRepository.getById(id);
    }
}
