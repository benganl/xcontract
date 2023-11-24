package za.co.wyzetech.cms.integration.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.wyzetech.cms.integration.mapper.ContractMapper;
import za.co.wyzetech.cms.integration.request.v1.ContractDto;
import za.co.wyzetech.cms.integration.response.v1.ResponseDto;
import za.co.wyzetech.cms.model.Contract;
import za.co.wyzetech.cms.service.ContractService;

@Slf4j
@RestController
public class RestfulController {


    private final ContractService contractService;
    private final ContractMapper contractMapper;

    public RestfulController(ContractService contractService, ContractMapper contractMapper) {
        this.contractService = contractService;
        this.contractMapper = contractMapper;
    }

    @RequestMapping(value = "/contract/create", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> create(@RequestBody ContractDto request) {
        Contract contract = contractMapper.convert(request);
        log.info("Contract[{}]", contract.toString());

        contractService.createNewContract(contract);

        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setResponseCode(0);
        return ResponseEntity.ok().body(response);
    }
}
