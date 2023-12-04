package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import lombok.Data;

@Data
public class ContractDto implements Serializable {
    private static final long serialVersionUID = -1L;
    private UUID id;

    private String reference;

    private Set<PartyDto> parties;

    private Set<ConditionDto> condition;

    private String stateRef;

    private Date startDate;

    private Date endDate;
}
