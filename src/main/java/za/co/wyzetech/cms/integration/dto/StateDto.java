package za.co.wyzetech.cms.integration.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class StateDto implements Serializable {
    private static final long serialVersionUID = -1L;

    private String name;

    private String description;

    private Date createDate;

    private Date startDate;

    private Date endDate;
}
