package za.co.wyzetech.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private String externalRef;
    private String identityNumber;
    private String identityType;
    private String address;
}