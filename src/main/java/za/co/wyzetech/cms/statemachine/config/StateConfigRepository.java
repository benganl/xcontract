package za.co.wyzetech.cms.statemachine.config;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.wyzetech.cms.statemachine.event.Event;
import za.co.wyzetech.cms.statemachine.state.State;

interface StateConfigRepository extends JpaRepository<StateConfig, UUID> {
    StateConfig findByCurrentStateAndEvent(State currentState, Event event);
}
