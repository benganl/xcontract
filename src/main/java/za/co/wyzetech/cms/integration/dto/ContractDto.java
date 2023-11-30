package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class ContractDto implements Serializable {
    private static final long serialVersionUID = -1L;
    private Long id;
    
    private String reference;

    private Set<PartyDto> parties;

    private Set<ConditionDto> condition;

    private Set<StateDto> stateHistory;

    private StateDto currentState;

    private Date startDate;

    private Date endDate;
    
    private List<String> validationErrors;
}
