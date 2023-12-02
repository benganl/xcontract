package za.co.wyzetech.cms.statemachine.state;

class DefaultStateService implements StateService {

    private final StateRepository stateRepository;

    public DefaultStateService(StateRepository stateRepository) {
	this.stateRepository = stateRepository;
    }

    @Override
    public State statusByName(String stateName) {
	return stateRepository.findByName(stateName);
    }
}
