package za.co.wyzetech.smartprocess.event.handler;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransitionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private ProcessStateDto currentState;

    private ProcessStateDto nextState;

    private ProcessEventDto event;
}
