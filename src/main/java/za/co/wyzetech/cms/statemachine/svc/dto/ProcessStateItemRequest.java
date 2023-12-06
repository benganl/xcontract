package za.co.wyzetech.cms.statemachine.svc.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProcessStateItemRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalRef;
    
    private String action;

}
