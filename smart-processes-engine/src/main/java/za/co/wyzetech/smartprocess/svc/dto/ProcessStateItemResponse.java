package za.co.wyzetech.smartprocess.svc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ProcessStateItemResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID stateItemId;
    private String externalRef;
    private String currentState;
    private Boolean success;
    private String message;
}
