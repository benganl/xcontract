package za.co.wyzetech.cms.statemachine.handler;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransitionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private StateItemDto currentState;

    private StateItemDto nextState;

    private EventDto event;

}
