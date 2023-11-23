package za.co.wyzetech.cms.model;

import lombok.Data;

import java.util.Date;

@Data
public class TermCondition {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Boolean active;
}
