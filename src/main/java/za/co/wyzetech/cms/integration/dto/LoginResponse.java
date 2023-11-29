package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = -1L;
    private String token;
    private Integer code;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(String token, Integer code, String message) {
	this.token = token;
	this.code = code;
	this.message = message;
    }
}
