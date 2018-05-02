package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "assuranceVie")
public class AssuranceVie extends AbstractCompte {

	@Column(name = "dateFin", nullable = true)
	private LocalDate dateFin;

	@Column(name = "taux", length = 50, nullable = false)
	private double taux;

	public AssuranceVie() {
	}

	public AssuranceVie(LocalDate dateFin, double taux, String numero, double solde) {
		this.setNumero(numero);
		this.setSolde(solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}
}
