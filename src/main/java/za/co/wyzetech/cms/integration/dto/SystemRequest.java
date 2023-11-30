package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SystemRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private AuthDto auth;
    private List<ContractDto> contracts;

}
