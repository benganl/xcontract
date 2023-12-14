package za.co.wyzetech.cms.statemachine.stateitem;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
class DefaultStateItemService implements StateItemService {

    private final StateItemRepository stateItemRepository;
    
    public DefaultStateItemService(StateItemRepository stateItemRepository) {
	this.stateItemRepository = stateItemRepository;
    }

    @Override
    public StateItem stateItemById(UUID id) {
	return stateItemRepository.getById(id);
    }

    @Override
    public StateItem create(StateItem stateItem) {
	return stateItemRepository.save(stateItem);
    }

    @Override
    public StateItem stateItemByExternalRef(String externalRef) {
	return stateItemRepository.findByExternalRef(externalRef);
    }
}
