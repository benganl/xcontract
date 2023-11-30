package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AuthDto implements Serializable {
    private String token;
}
