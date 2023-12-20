package za.co.wyzetech.smartprocess.process;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.wyzetech.smartprocess.state.ProcessState;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Entity
@Table(name = "smart_process")
public class SmartProcess implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column("external_ref")
    private String externalRef;

    @ManyToOne(optional = false)
    @JoinColumn(name = "current_state")
    private ProcessState currentState;

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	SmartProcess other = (SmartProcess) obj;
	return Objects.equals(id, other.id);
    }
}
