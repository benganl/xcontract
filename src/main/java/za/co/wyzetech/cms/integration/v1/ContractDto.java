package za.co.wyzetech.cms.integration.v1;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContractDto {
    private List<PartyDto> parties;
    private List<TermConditionDto> termsAndConditions;
    private Date startDate;
    private Date endDate;
}
