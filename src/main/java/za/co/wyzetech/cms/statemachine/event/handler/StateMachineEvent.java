package za.co.wyzetech.cms.statemachine.event.handler;

import java.io.Serializable;
import java.util.function.Function;

import za.co.wyzetech.cms.statemachine.handler.StateItemDto;
import za.co.wyzetech.cms.statemachine.handler.TransitionDto;

public final class StateMachineEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TransitionDto transitionDto;
    private final StateItemDto stateItemDto;

    public StateMachineEvent(StateMachineEventBuilder builder) {
	this.transitionDto = builder.transition;
	this.stateItemDto = builder.stateItem;
    }

    public StateMachineEvent(TransitionDto transitionDto, StateItemDto stateItemDto) {
	super();
	this.transitionDto = transitionDto;
	this.stateItemDto = stateItemDto;
    }
}
