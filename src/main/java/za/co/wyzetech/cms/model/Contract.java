package za.co.wyzetech.cms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract implements Serializable {
    private static final long serialVersionUID = -1L;

    private Set<Party> parties;
    private Set<TermCondition> termsAndConditions;
    private Set<ContractStatus> statusHistory;
    private ContractStatus status;
    private Date startDate;
    private Date endDate;
    private UUID id;
}
