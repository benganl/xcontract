package za.co.wyzetech.cms.statemachine.event.handler;

import java.io.Serializable;

public final class StateMachineEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TransitionDto transitionDto;
    private final StateItemDto stateItemDto;

    public StateMachineEvent(StateMachineEventBuilder builder) {
	this.transitionDto = builder.transition;
	this.stateItemDto = builder.stateItem;
    }

    public StateMachineEvent(TransitionDto transitionDto, StateItemDto stateItemDto) {
	this.transitionDto = transitionDto;
	this.stateItemDto = stateItemDto;
    }
}
