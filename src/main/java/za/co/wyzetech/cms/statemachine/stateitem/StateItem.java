package za.co.wyzetech.cms.statemachine.stateitem;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import za.co.wyzetech.cms.statemachine.state.State;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cms_state_item")
public class StateItem implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "external_ref")
    private String externalRef;

    @ManyToOne(optional = false)
    @JoinColumn(name = "current_state")
    private State currentState;

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
	StateItem other = (StateItem) obj;
	return Objects.equals(id, other.id);
    }
}
