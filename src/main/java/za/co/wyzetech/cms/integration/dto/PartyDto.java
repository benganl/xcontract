package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PartyDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long contractNumber;
    private String name;
    private String externalRef;
    private String identityNumber;
    private String identityType;
    private String address;
}
