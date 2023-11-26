package za.co.wyzetech.cms.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TermCondition implements Serializable {
    private static final long serialVersionUID = -1L;
    private String name;
    private String description;
    private String value;
    private Date startDate;
    private Date endDate;
    private Boolean active;
}
