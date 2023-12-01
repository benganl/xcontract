package za.co.wyzetech.cms.workflow.state;

import org.springframework.stereotype.Service;

import za.co.wyzetech.cms.workflow.StateDescription;

@Service
class DefaultStateService implements StateService {
    private final StateRepository stateRepository;

    public DefaultStateService(StateRepository stateRepository) {
	this.stateRepository = stateRepository;
    }

    @Override
    public State newState() {
	return stateRepository.getByName(StateDescription.NEW.value());
    }

    @Override
    public String create(State state) {
	State managed = stateRepository.save(state);
	return managed.getId().toString();
    }
}
