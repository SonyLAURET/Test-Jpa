package banque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livretASingleTable")
@DiscriminatorColumn(name = "livret A")
public class LivretA extends AbstractCompte {

	@Column(name = "taux", length = 50, nullable = false)
	private double taux;

	public LivretA() {

	}

	public LivretA(double taux, String numero, double solde) {
		this.setNumero(numero);
		this.setSolde(solde);
		this.taux = taux;
	}
}
