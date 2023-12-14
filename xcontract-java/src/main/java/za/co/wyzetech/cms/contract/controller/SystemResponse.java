package za.co.wyzetech.cms.contract.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import za.co.wyzetech.cms.contract.dto.ContractDto;

@Data
public class SystemResponse implements Serializable {
    private static final long serialVersionUID = -1L;
    private List<ContractDto> contracts = new ArrayList<>();
    private Integer responseCode;
    private String message;
    private List<String> errors;
}
