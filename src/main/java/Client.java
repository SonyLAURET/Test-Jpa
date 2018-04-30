import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "client")
public class Client {

	public Client() {

	}

	private static final Logger LOG = LoggerFactory.getLogger(Emprunt.class);

	@Id
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;

	@OneToMany(mappedBy = "client")
	private Set<Emprunt> emprunts;

	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

}
