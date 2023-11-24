package za.co.wyzetech.cms.integration.request.v1;

import lombok.Data;

@Data
public class PartyDto {
    private String name;
    private String externalRef;
    private String identityNumber;
    private String identityType;
    private String address;
}
