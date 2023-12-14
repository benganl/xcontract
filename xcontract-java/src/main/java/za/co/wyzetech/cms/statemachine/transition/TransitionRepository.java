package za.co.wyzetech.cms.statemachine.transition;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

interface TransitionRepository extends JpaRepository<Transition, UUID> {
    Transition findByCurrentStateAndEvent(State currentState, Event event);
}
