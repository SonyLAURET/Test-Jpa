package banque;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "client")
public class Client {

	private static final Logger LOG = LoggerFactory.getLogger(Client.class);

	public Client() {
	}

	public Client(String nom, String prenom, LocalDate dateNaissance, Adresse adresse, Banque banque) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.banque = banque;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false)
	private String prenom;

	@Column(name = "DATE_NAISSANCE", nullable = false)
	private LocalDate dateNaissance;

	@Embedded
	private Adresse adresse;

	@ManyToOne
	@JoinColumn(name = "BANQUE_ID")
	private Banque banque;

	@ManyToMany(mappedBy = "clients")
	private Set<AbstractCompte> comptes;
}