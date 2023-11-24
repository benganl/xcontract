package za.co.wyzetech.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {
    private String name;
    private String externalRef;
    private String identityNumber;
    private String identityType;
    private String address;
}