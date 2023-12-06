package za.co.wyzetech.cms.contract.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import za.co.wyzetech.cms.contract.ContractService;
import za.co.wyzetech.cms.contract.dto.ContractDto;
import za.co.wyzetech.cms.contract.mapper.ContractMapper;
import za.co.wyzetech.cms.contract.model.Contract;

@Slf4j
@RestController
@RequestMapping("/svc/contract")
public class ContractController {

    private final ContractService contractService;
    private final ContractMapper contractMapper;

    public ContractController(ContractService contractService, ContractMapper contractMapper) {
	this.contractService = contractService;
	this.contractMapper = contractMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<SystemResponse> createContract(@RequestBody SystemRequest request) {
	final SystemResponse response = new SystemResponse();

	for (ContractDto contractDto : request.getContracts()) {
	    final Contract contract = contractMapper.convert(contractDto);
	    log.info("Contract[{}]", contract.toString());
	    List<String> validationErrors = contractService.validate(contract);
	    if (validationErrors.isEmpty()) {
		contractService.create(contract);
	    }
	    // contractDto.setValidationErrors(validationErrors);
	    response.setContracts(new ArrayList<>());
	    response.getContracts().add(contractDto);
	}

	response.setMessage("SUCCESS");
	response.setResponseCode(ResponseCodes.SUCCESS);
	return ResponseEntity.ok().body(response);
    }
}