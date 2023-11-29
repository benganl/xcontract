package za.co.wyzetech.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
	    name = "contract_participants",
	    joinColumns = { @JoinColumn(name = "contract_id", nullable = false) },
	    inverseJoinColumns = { @JoinColumn(name = "party_id", nullable = false) })
    private Set<Party> parties;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
	    name = "contract_conditions",
	    joinColumns = { @JoinColumn(name = "contract_id", nullable = false) },
	    inverseJoinColumns = { @JoinColumn(name = "condition_id", nullable = false) })
    private Set<Condition> condition;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
	    name = "contract_status",
	    joinColumns = { @JoinColumn(name = "contract_id", nullable = false) },
	    inverseJoinColumns = { @JoinColumn(name = "status_id", nullable = false) })
    private Set<Status> statusHistory;

    @JoinColumn(name = "current_status", referencedColumnName = "id")
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;
}
