package za.co.wyzetech.cms.contract.controller;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import za.co.wyzetech.cms.contract.dto.ContractDto;

@Data
public class SystemRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<ContractDto> contracts;

}
