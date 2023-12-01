package za.co.wyzetech.cms.contract.model;

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

    @Column(name = "reference_id")
    private String reference;

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

    @Column(name = "state_ref", nullable = true)
    private String stateRef;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date")
    private Date endDate;
}
