package za.co.wyzetech.smartprocess.event.handler;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProcessStateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    private Date createDate;
}
