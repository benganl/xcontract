package za.co.wyzetech.cms.integration.restful;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.wyzetech.cms.integration.response.v1.ResponseDto;
import za.co.wyzetech.cms.integration.request.v1.ContractDto;

@RestController
public class RestfulController {

    @RequestMapping(value = "/contract/create", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> create(@RequestBody ContractDto contract) {
        ResponseDto response = new ResponseDto();
        response.setMessage("success");
        response.setResponseCode(0);
        return ResponseEntity.ok().body(response);
    }
}
