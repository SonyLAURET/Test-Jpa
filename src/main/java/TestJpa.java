import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpa {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);

	public static void main(String[] args) {

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
			EntityManager em = entityManagerFactory.createEntityManager();

			em.getTransaction().begin();
			// Livre livre1 = new Livre();
			// livre1.findById(em, 1);
			// livre1.findByTitle(em, "Germinal");

			// for find all book which are the same loan
			// Set<Livre> livres = em.find(Emprunt.class, 1).getLivres();
			// Iterator<Livre> it = livres.iterator();
			// while (it.hasNext()) {
			// LOG.error(it.next().toString());
			//
			// }

			// for find all loans which are the same client
			Set<Emprunt> emprunts = em.find(ClientPizza.class, 1).getEmprunts();
			Iterator<Emprunt> ite = emprunts.iterator();
			while (ite.hasNext()) {
				LOG.error(ite.next().toString());
			}

		} catch (IllegalArgumentException e) {
			LOG.error("entityManager exception : ", e);
		}

	}

}
