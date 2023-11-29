package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import lombok.Data;
import za.co.wyzetech.cms.model.Condition;
import za.co.wyzetech.cms.model.Party;
import za.co.wyzetech.cms.model.Status;

@Data
public class ContractDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private Long id;

    private Set<Party> parties;

    private Set<Condition> condition;

    private Set<Status> statusHistory;

    private Status status;

    private Date startDate;
    private Date endDate;
}
