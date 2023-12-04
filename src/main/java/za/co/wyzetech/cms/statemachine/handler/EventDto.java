package za.co.wyzetech.cms.statemachine.handler;

import java.io.Serializable;

import lombok.Data;

@Data
public class EventDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String description;
}
