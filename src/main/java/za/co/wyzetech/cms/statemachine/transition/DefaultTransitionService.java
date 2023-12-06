package za.co.wyzetech.cms.statemachine.transition;

import org.springframework.stereotype.Service;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

@Service
class DefaultTransitionService implements TransitionService {
    private final TransitionRepository transitionRepository;

    public DefaultTransitionService(TransitionRepository transitionRepository) {
        this.transitionRepository = transitionRepository;
    }

    @Override
    public Transition nextState(State currentState, Event event) {
        Transition transition = transitionRepository.findByCurrentStateAndEvent(currentState, event);
        return transition;
    }
}
