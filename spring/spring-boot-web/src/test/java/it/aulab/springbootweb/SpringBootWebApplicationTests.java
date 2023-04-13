package it.aulab.springbootweb;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import it.aulab.springbootweb.model.Fornitore;
import it.aulab.springbootweb.model.Prodotto;
import it.aulab.springbootweb.model.Variante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringBootWebApplicationTests {
	
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
		
		Assertions.assertThat(allBeforePersist).hasSize(0);
		
		entityManager.persist(p);
		
		List<Prodotto> allAterPersist = q.getResultList();
		
		Assertions.assertThat(allAterPersist).hasSize(1);
		
	}
	
	@Test
	void checkPrezzoNetto() {
		Prodotto p = new Prodotto();

		p.setNome("Maglia Nike");
		p.setDescrizione("Maglia in cotone");
		p.setPrezzo(30F);
		p.setPrezzoNetto(20F);

		entityManager.persist(p);

		TypedQuery<Prodotto> q = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = 1", Prodotto.class);

		Prodotto queryP = q.getSingleResult();

		Assertions.assertThat(queryP).extracting("prezzoNetto").isEqualTo(20F);

	}

	@Test
	void checkManyToOneRelation() {

		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT v FROM Variante v WHERE v.id = 1", Prodotto.class);
		Prodotto p = q1.getSingleResult();


		TypedQuery<Variante> q2 = entityManager.createQuery("SELECT v FROM Variante v WHERE v.id = 1", Variante.class);

		Variante v = q2.getSingleResult();

		Assertions.assertThat(v).extracting("prodotto").isEqualTo(p);

	}

	@Test
	void checkOneToManyRelation() {

		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p WHERE p.id = 1", Prodotto.class);
		Prodotto p = q1.getSingleResult();

		Assertions.assertThat(p).extracting("varianti").asList().hasSize(4);

	}

	@Test
	void checkProdottiFromFornitori() {
		/*
		 * 
		 * select f1_0.id,f1_0.nome from fornitori f1_0
		 * 
		 * select
		 * p1_0.fornitore_id,p1_1.id,p1_1.descrizione,p1_1.nome,p1_1.prezzo,p1_1.netto
		 * from fornitori_prodotti p1_0
		 * join prodotti p1_1 on p1_1.id=p1_0.prodotto_id
		 * where p1_0.fornitore_id=?
		 * 
		 */
		TypedQuery<Fornitore> q = entityManager.createQuery("SELECT f FROM Fornitore f", Fornitore.class);

		List<Fornitore> all = q.getResultList();

		Assertions.assertThat(all.get(0)).extracting("prodotti").asList().hasSize(1);
		Assertions.assertThat(all.get(1)).extracting("prodotti").asList().hasSize(4);
		Assertions.assertThat(all.get(2)).extracting("prodotti").asList().hasSize(2);
	}

	@Test
	void checkFornitoriFromProdotti() {
		// String sql = "SELECT p FROM Prodotto p WHERE id = ";

		/*
		 * select p1_0.id,p1_0.descrizione,p1_0.nome,p1_0.prezzo,p1_0.netto from
		 * prodotti p1_0 where p1_0.id=1
		 */
		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = 1", Prodotto.class);
		Prodotto p1 = q1.getSingleResult();

		/*
		 * select f1_0.prodotto_id,f1_1.id,f1_1.nome
		 * from fornitori_prodotti f1_0
		 * join fornitori f1_1 on f1_1.id=f1_0.fornitore_id where f1_0.prodotto_id=?
		 */
		Assertions.assertThat(p1).extracting("fornitori").asList().hasSize(2);

		TypedQuery<Prodotto> q2 = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = 4", Prodotto.class);
		Prodotto p4 = q2.getSingleResult();

		Assertions.assertThat(p4).extracting("fornitori").asList().hasSize(1);
	}

	@Test
	void checkRelationInsert() {
		TypedQuery<Prodotto> q1 = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = 1", Prodotto.class);
		Prodotto p1 = q1.getSingleResult();

		/*
		 * insert into varianti (attributo, prodotto_id, valore) values (?, ?, ?)
		 */
		// Prodotto p1 = new Prodotto();
		// p1.setId(1L);
		// p1.setNome("Maglia Lacoste");
		// p1.setDescrizione("Maglia cotone");
		// p1.setPrezzo(100F);
		// p1.setPrezzoNetto(80F);

		Variante newVariant1 = new Variante();
		newVariant1.setAttributo("taglia");
		newVariant1.setValore("xl");
		newVariant1.setProdotto(p1);

		entityManager.persist(newVariant1);

		Variante newVariant2 = new Variante();
		newVariant2.setAttributo("taglia");
		newVariant2.setValore("xs");
		newVariant2.setProdotto(p1);

		entityManager.persist(newVariant2);

		TypedQuery<Prodotto> queryAll = entityManager.createQuery("SELECT p FROM Prodotto p", Prodotto.class);
		List<Prodotto> prodotti = queryAll.getResultList();

		Assertions.assertThat(prodotti.get(0)).extracting("varianti").asList().hasSize(6);

	}

	@Test
	void checkDeleteRelation() {
		TypedQuery<Fornitore> q1 = entityManager.createQuery("SELECT f FROM Fornitore f WHERE id = 1", Fornitore.class);
		Fornitore f1 = q1.getSingleResult();

		Prodotto p = new Prodotto();
		p.setNome("x");
		p.setDescrizione("x");
		p.setPrezzo(1F);
		p.setPrezzoNetto(0.8F);

		entityManager.persist(p);

		f1.getProdotti().add(p);

		entityManager.persist(f1);

		TypedQuery<Fornitore> queryAll = entityManager.createQuery("SELECT f FROM Fornitore f", Fornitore.class);
		List<Fornitore> fornitori = queryAll.getResultList();

		Assertions.assertThat(fornitori.get(0)).extracting("prodotti").asList().hasSize(2);

		// entityManager.remove(p);

		// TypedQuery<Fornitore> queryAll2 = entityManager.createQuery("SELECT f FROM Fornitore f", Fornitore.class);
		// List<Fornitore> fornitori2 = queryAll2.getResultList();

		// Assertions.assertThat(fornitori2.get(0)).extracting("prodotti").asList().hasSize(1);

		entityManager.remove(f1);

		TypedQuery<Prodotto> queryProdotto = entityManager.createQuery("SELECT p FROM Prodotto p WHERE id = " + p.getId(), Prodotto.class);
		Prodotto prodotto = queryProdotto.getSingleResult();

		Assertions.assertThat(prodotto).extracting("fornitori").asList().hasSize(0);

	}

	
}
