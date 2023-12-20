package za.co.wyzetech.smartprocess.config;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.wyzetech.smartprocess.event.ProcessEvent;
import za.co.wyzetech.smartprocess.state.ProcessState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Entity
@Table(name = "process_config")
public class ProcessConfig implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "current_state_id")
    private ProcessState currentState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "next_state_id")
    private ProcessState nextState;

    @ManyToOne(optional = false)
    @JoinColumn(name = "event_id")
    private ProcessEvent processEvent;
}
