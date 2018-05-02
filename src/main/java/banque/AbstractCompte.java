package banque;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compteSingleTable")

/** heritage "single table */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")

/**
 * heritage "table per subclass"
 * 
 * @Inheritance(strategy = InheritanceType.JOINED)
 */

public abstract class AbstractCompte {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "solde", nullable = false)
	private double solde;

	@OneToMany(mappedBy = "compte")
	private Set<AbstractOperation> operations;

	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT", joinColumns = @JoinColumn(name = "COMPTE_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "Client_ID", referencedColumnName = "ID"))
	private Set<Client> clients;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Set<AbstractOperation> getOperations() {
		return operations;
	}

	public void setOperations(Set<AbstractOperation> operations) {
		this.operations = operations;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
