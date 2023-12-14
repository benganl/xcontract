package za.co.wyzetech.cms.statemachine.event.handler;

import java.io.Serializable;

import lombok.Data;

@Data
public class StateItemDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalRef;

    private StateDto currentState;

}
