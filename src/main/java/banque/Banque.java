package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque")
public class Banque {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;

	public Banque() {
	}

	public Banque(String nom) {
		this.nom = nom;
	}
}
