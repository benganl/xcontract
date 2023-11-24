package za.co.wyzetech.cms.integration.request.v1;

import lombok.Data;
import za.co.wyzetech.cms.model.ContractStatus;
import za.co.wyzetech.cms.model.Party;
import za.co.wyzetech.cms.model.TermCondition;

import java.util.Date;
import java.util.Set;

@Data
public class ContractDto {
    private Set<Party> parties;
    private Set<TermCondition> termsAndConditions;
    private Set<ContractStatus> statusHistory;
    private ContractStatus status;
    private Date startDate;
    private Date endDate;
}
