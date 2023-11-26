package za.co.wyzetech.cms.integration.restful;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

import java.util.Arrays;
import java.util.List;

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
        final Contract contract = contractMapper.convert(request);
        final ResponseDto response = new ResponseDto();

        log.info("Contract[{}]", contract.toString());

        List<String> validationErrors = contractService.validate(contract);

        try {
            if (validationErrors.isEmpty()) {
                contractService.createNewContract(contract);
                response.setMessage("SUCCESS");
                response.setResponseCode(SystemCodes.SUCCESS);
                return ResponseEntity.ok().body(response);
            } else {
                response.setMessage("ERROR");
                response.setErrors(validationErrors);
                response.setResponseCode(SystemCodes.PAYLOAD_VALIDATION_ERROR);
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setErrors(Arrays.asList(e.getCause().toString()));
            response.setResponseCode(SystemCodes.EXPECTATION_FAILED);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(response);
        }
    }
}
