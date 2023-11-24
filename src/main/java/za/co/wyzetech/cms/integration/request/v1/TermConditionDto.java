package za.co.wyzetech.cms.integration.request.v1;

import lombok.Data;

import java.util.Date;

@Data
public class TermConditionDto {
    private String name;
    private String description;
    private String value;
    private Date startDate;
    private Date endDate;
    private Boolean active;
}
