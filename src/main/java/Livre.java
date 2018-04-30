import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "livre")
public class Livre {

	private static final Logger LOG = LoggerFactory.getLogger(Livre.class);

	@Id
	private Integer id;

	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;

	@Column(name = "Auteur", length = 50, nullable = false)
	private String auteur;

	public Livre() {
	}

	public void findById(EntityManager em, int id) {
		Livre livre1 = em.find(Livre.class, id);
		if (livre1 != null) {
			LOG.error(livre1.toString());
		}

	}

	public void findByTitle(EntityManager em, String title) {
		Query query = em.createQuery("from Livre where titre='" + title + "'");
		Livre livre1 = (Livre) query.getSingleResult();
		LOG.error(livre1.toString());
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}
}
