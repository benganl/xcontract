package za.co.wyzetech.smartprocess.state;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @Entity
@Table(name = "process_state")
@Cacheable
public class ProcessState implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("start_date")
    private Date startDate;

    @Column("end_date")
    private Date endDate;

    @Column("create_date")
    private Date createDate;

    @Override
    public int hashCode() {
	return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ProcessState other = (ProcessState) obj;
	return Objects.equals(name, other.name);
    }
}