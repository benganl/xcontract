package za.co.wyzetech.cms.contract.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class ConditionDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private UUID id;

    private String name;

    private String description;

    private String value;

    private Date startDate;

    private Date endDate;

    private Boolean active;
}