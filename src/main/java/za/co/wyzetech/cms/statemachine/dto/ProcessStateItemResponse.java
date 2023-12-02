package za.co.wyzetech.cms.statemachine.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class ProcessStateItemResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID stateItemId;
    private String externalRef;
    private String currentState;
    private Boolean success;
    private String message;
}
