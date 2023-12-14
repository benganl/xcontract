package za.co.wyzetech.cms.statemachine.event.handler;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class StateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    private Date createDate;
}
