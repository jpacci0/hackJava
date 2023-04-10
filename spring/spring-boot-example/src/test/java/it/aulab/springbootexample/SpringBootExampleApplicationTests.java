package it.aulab.springbootexample;

import java.util.List;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;

import it.aulab.springbootexample.model.Prodotto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootExampleApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Test
	void persistObjectProdotto() {
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		Prodotto p = new Prodotto();

		p.setNome("Maglia Nike");
		p.setDescrizione("Maglia in cotone");
		p.setPrezzo(30F);

		List<Prodotto> allBeforePersist = q.getResultList();

		Assertions.assertThat(allBeforePersist).hasSize(4);

		entityManager.persist(p);

		List<Prodotto> allAterPersist = q.getResultList();

		Assertions.assertThat(allAterPersist).hasSize(5);
		

	}

	@Test
	void updateObjectProdotto() {
		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);

		List<Prodotto> all = q.getResultList();

		Prodotto p = all.get(0);

		String n = "nuovo nome";
		String d = "nuova descrizione";
		p.setNome(n);
		p.setDescrizione(d);

		entityManager.persist(p);

		List<Prodotto> allAfterPersist = q.getResultList();
		
		p = allAfterPersist.get(0);

		Assertions.assertThat(p).extracting("nome").isEqualTo(n);
		Assertions.assertThat(p).extracting("descrizione").isEqualTo(d);

	}

	@Test
	public void testRemoveObjectProdotto() {
		// Creazione di un oggetto Prodotto da persistere nel database
		Prodotto prodotto = new Prodotto();
		prodotto.setNome("Prodotto da eliminare");

		// Persistenza dell'oggetto nel database
		entityManager.persist(prodotto);

		// Esecuzione della query per ottenere il totale delle righe prima dell'eliminazione
		TypedQuery<Long> countQuery = entityManager.createQuery("SELECT COUNT(p) FROM Prodotto p", Long.class);
		Long countBefore = countQuery.getSingleResult();

		// Rimozione dell'oggetto Prodotto dal database utilizzando il metodo remove dell'entityManager
		entityManager.remove(prodotto);

		// Esecuzione della query per ottenere il totale delle righe dopo l'eliminazione
		Long countAfter = countQuery.getSingleResult();

		// Verifica che l'oggetto sia stato rimosso dal database
		Assertions.assertThat(countAfter).isEqualTo(countBefore - 1);
	}


}

