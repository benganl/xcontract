package za.co.wyzetech.smartprocess.svc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StateMachineRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalRef;

}
