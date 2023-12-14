package za.co.wyzetech.cms.contract.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class PartyDto implements Serializable {
    private static final long serialVersionUID = -1L;
    private UUID id;

    private String name;

    private String externalRef;

    private String identityNumber;

    private String identityType;

    private String address;
}
