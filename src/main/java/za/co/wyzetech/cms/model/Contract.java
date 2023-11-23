package za.co.wyzetech.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    private Set<Party> parties;
    private Set<TermCondition> termsAndConditions;
    private Set<ContractStatus> statusHistory;
    private ContractStatus status;
    private Date startDate;
    private Date endDate;
}
