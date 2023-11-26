package za.co.wyzetech.cms.integration.response.v1;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDto {
    private Integer responseCode;
    private String message;
    private List<String> errors;
}
