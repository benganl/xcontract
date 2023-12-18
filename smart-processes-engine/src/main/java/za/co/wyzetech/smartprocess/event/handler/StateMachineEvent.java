package za.co.wyzetech.smartprocess.event.handler;

import java.io.Serializable;

public final class StateMachineEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private final TransitionDto transitionDto;
    private final SmartProcessDto smartProcessDto;

    public StateMachineEvent(StateMachineEventBuilder builder) {
        this.transitionDto = builder.transition;
        this.smartProcessDto = builder.stateItem;
    }

    public StateMachineEvent(TransitionDto transitionDto, SmartProcessDto smartProcessDto) {
        this.transitionDto = transitionDto;
        this.smartProcessDto = smartProcessDto;
    }
}
