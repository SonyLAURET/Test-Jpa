package banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJpaBanque {

	private static final Logger LOG = LoggerFactory.getLogger(TestJpaBanque.class);

	public static void main(String[] args) {
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque_essai");
			EntityManager em = entityManagerFactory.createEntityManager();

			/** open connection */
			em.getTransaction().begin();

			/** instancie une adresse */
			Adresse adresse = new Adresse(4, "Heritage single", 44800, "Saint-test1");
			Adresse adresse1 = new Adresse(4, "Heritage table per class", 44800, "Saint-test2");

			/** instancie une banque et la fait persister */
			Banque banque1 = new Banque("la");
			Banque banque2 = new Banque("bas");
			em.persist(banque1);
			em.persist(banque2);

			/**
			 * banque et adresse sont créées, on peut alors instancier client et
			 * le faire persister
			 */
			Client client = new Client("Nom", "Prenom", LocalDate.of(1991, 1, 01), adresse, banque1);
			Set<Client> client1 = new HashSet<Client>();
			client1.add(client);
			em.persist(client);
			LOG.error("blabla");

			/**
			 * on instancie assurance vie et livret A qui vont persister dans la
			 * table compte
			 */
			AssuranceVie assuranceVie1 = new AssuranceVie(LocalDate.of(2014, 5, 20), 0.2, "200SingleTable", 1000);
			em.persist(assuranceVie1);

			LivretA livretA = new LivretA(0.3, "300SingleTAble", 4500);
			em.persist(livretA);

			/**
			 * on instancie virement qui va persister dans la table operation
			 */
			Virement virement = new Virement("Table per class", LocalDate.now(), 1000, "pour heriter");
			em.persist(virement);

			/** on sauvegarde les objets */
			em.getTransaction().commit();

			/** on ferme la connexion */
			em.close();

		} catch (IllegalArgumentException e) {
			LOG.error("entityManager exception : ", e);
		}

	}

}
