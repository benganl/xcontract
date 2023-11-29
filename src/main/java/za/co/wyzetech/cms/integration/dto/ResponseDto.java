package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ResponseDto implements Serializable {
    private static final long serialVersionUID = -1L;
    private Integer responseCode;
    private String message;
    private List<String> errors;
}
