package za.co.wyzetech.cms.statemachine.config;

import org.springframework.stereotype.Service;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

@Service
class DefaultStateConfigService implements StateConfigService {
    private final StateConfigRepository stateConfigRepository;

    public DefaultStateConfigService(StateConfigRepository stateConfigRepository) {
        this.stateConfigRepository = stateConfigRepository;
    }

    @Override
    public StateConfig nextState(State currentState, Event event) {
        StateConfig stateConfig = stateConfigRepository.findByCurrentStateAndEvent(currentState, event);
        return stateConfig;
    }
}
