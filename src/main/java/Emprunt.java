import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "emprunt")
public class Emprunt {

	public Emprunt() {

	}

	private static final Logger LOG = LoggerFactory.getLogger(Emprunt.class);

	@Id
	private Integer id;

	@Column(name = "DATE_DEBUT", nullable = false)
	private Date date_debut;

	@Column(name = "DELAI", length = 10, nullable = true)
	private Integer delai;

	@Column(name = "DATE_FIN", length = 255, nullable = true)
	private Date date_fin;

	@ManyToOne
	@JoinColumn(name = "ID_client")
	private ClientPizza client;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", livres=" + livres + "]";
	}

}
