package za.co.wyzetech.smartprocess.event.handler;

import lombok.Data;

import java.io.Serializable;

@Data
public class SmartProcessDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalRef;

    private ProcessStateDto currentState;

}
