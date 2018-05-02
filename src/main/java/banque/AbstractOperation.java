package banque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public abstract class AbstractOperation {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "motif", length = 50, nullable = false)
	private String motif;

	@Column(name = "montant", length = 50, nullable = false)
	private double montant;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@ManyToOne
	@JoinColumn(name = "COMPTE_ID")
	private AbstractCompte compte;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
