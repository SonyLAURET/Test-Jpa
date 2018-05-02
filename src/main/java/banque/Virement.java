package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "virement")
public class Virement extends AbstractOperation {

	@Column(name = "beneficiare", length = 50, nullable = false)
	private String beneficaire;

	public Virement() {

	}

	public Virement(String beneficaire, LocalDateTime date, double montant, String motif) {
		this.setDate(date);
		this.setMontant(montant);
		this.setMotif(motif);
		this.beneficaire = beneficaire;
	}

}
