package za.co.wyzetech.cms.statemachine.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String externalRef;

}
