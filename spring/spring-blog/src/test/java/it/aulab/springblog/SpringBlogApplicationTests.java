package it.aulab.springblog;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
// import org.springframework.data.domain.Sort.Direction;

import it.aulab.springblog.model.Author;
import it.aulab.springblog.model.Comment;
import it.aulab.springblog.model.Post;
import it.aulab.springblog.repository.CrudAuthorRepository;
import it.aulab.springblog.repository.JpaAuthorRepository;
import it.aulab.springblog.repository.PagingAndSortingAuthorRepository;
import jakarta.persistence.EntityManager;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBlogApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private JpaAuthorRepository authorRepository;

	@Autowired
	private CrudAuthorRepository crudAuthorRepository;

	@Autowired
	private PagingAndSortingAuthorRepository pAndSAuthorRepository;

	@BeforeEach
	public void createData() {
		Author a1 = new Author();
		a1.setFirstname("Jacopo");
		a1.setLastname("Paccioretti");
		a1.setEmail("jp@gmail.com");

		entityManager.persist(a1);

		Author a2 = new Author();
		a2.setFirstname("Giorgio");
		a2.setLastname("rossi");
		a2.setEmail("jp@gmail.com");

		entityManager.persist(a2);

		Post p1 = new Post();
		p1.setAuthor(a1);
		p1.setTitle("Il nuovo Pixel 7 Pro");
		p1.setBody("Lorem ipsum");
		p1.setPublishDate("20230411");

		entityManager.persist(p1);

		Post p2 = new Post();
		p2.setAuthor(a1);
		p2.setTitle("Il nuovo IPhone 14");
		p2.setBody("Lorem ipsum");
		p2.setPublishDate("20230411");

		entityManager.persist(p2);

		Comment c1 = new Comment();
		c1.setEmail("jp@gmail.com");
		c1.setPost(p1);
		c1.setBody("si");
		c1.setPublishDate("20230411");

		Comment c2 = new Comment();
		c2.setEmail("jp@gmail.com");
		c2.setPost(p1);
		c2.setBody("bph");
		c1.setPublishDate("20230412");

		entityManager.persist(c1);
		entityManager.persist(c2);

	}

	@Test
	void authorCheck() {

		List<Author> authors = entityManager
				.createQuery("SELECT a FROM Author a", Author.class)
				.getResultList();

		assertThat(authors).hasSize(2);
	}

	@Test
	void postCheck() {

		List<Post> posts = entityManager
				.createQuery("SELECT p FROM Post p", Post.class)
				.getResultList();

		assertThat(posts).hasSize(2);
	}

	@Test
	void commentCheck() {

		List<Post> posts = entityManager
				.createQuery("SELECT p FROM Post p", Post.class)
				.getResultList();

		System.out.println(posts.get(0).getId());
		List<Comment> commmentsPost1 = entityManager.createQuery(
				"SELECT c FROM Comment c WHERE c.post.id = ?1",
				Comment.class).setParameter(1, posts.get(0).getId())
				.getResultList();

		assertThat(commmentsPost1).hasSize(2);

		System.out.println(posts.get(1).getId());
		List<Comment> commmentsPost2 = entityManager.createQuery(
				"SELECT c FROM Comment c WHERE c.post.id = ?1",
				Comment.class).setParameter(1, posts.get(1).getId())
				.getResultList();

		assertThat(commmentsPost2).hasSize(0);
	}

	@Test
	void queryCheck() {

		List<Post> posts = entityManager
				.createQuery("SELECT p FROM Post p", Post.class)
				.getResultList();

		List<Comment> commment = entityManager.createQuery(
				"SELECT c FROM Comment c WHERE c.post.id = ?1 AND c.email = ?2",
				Comment.class)
				.setParameter(1, posts.get(0).getId())
				.setParameter(2, "jp@gmail.com")
				.getResultList();

		assertThat(commment).hasSize(2);
	}

	@Test
	void authorRepositoryCheck() {
		assertThat(authorRepository.count()).isEqualTo(2);

		assertThat(authorRepository.findAll())
				.first()
				.extracting("firstname")
				.isEqualTo("Giorgio");

		Author a = authorRepository.findAll().get(0);

		assertThat(authorRepository.findById(a.getId()).get())
				.isNotNull()
				.extracting("lastname")
				.isEqualTo("Rossi");
	}

	// @Test
	// void findByLastName() {
		
	// 	assertThat(authorRepository.findByLastName("Rossi"))
	// 			.first()
	// 			.extracting("lastName")
	// 			.isEqualTo("Rossi");
	// }

	// @Test
	// void findByFirstnameAndLastname() {

	// 	assertThat(authorRepository.findByFirstNameAndLastName("Jacopo", "Rossi"))
	// 			.hasSize(0);

	// 	assertThat(authorRepository.findByFirstNameOrLastName("jacopo", "rossi"))
	// 			.hasSize(2);
	// }

	// @Test
	// void notIgnoreCase() {

	// 	assertThat(authorRepository.findByFirstNameNotIgnoreCase("jacopo"))
	// 			.first()
	// 			.extracting("firstname")
	// 			.isEqualTo("Giorgio");

	// 	assertThat(authorRepository.findByFirstNameEquals("jacopo")).first()
	// 			.extracting("firstname")
	// 			.isEqualTo("Jacopo");

	// 	assertThat(authorRepository.findByFirstNameContains("r")).hasSize(2);

	// }

	// @Test
	// void createCrud() {
	// 	Author a = new Author();
	// 	a.setFirstname("Gianvito");
	// 	a.setLastname("Palmisano");
	// 	a.setEmail("gvpalm@gmail.com");

	// 	crudAuthorRepository.save(a);

	// 	assertThat(crudAuthorRepository.findAll()).hasSize(3);

	// }

	// @Test
	// void createJpa() {
	// 	Author a = new Author();
	// 	a.setFirstname("Gianvito");
	// 	a.setLastname("Palmisano");
	// 	a.setEmail("gvpalm@gmail.com");

	// 	authorRepository.save(a);

	// 	assertThat(authorRepository.findAll()).hasSize(3);

	// }

	// @Test
	// void sorting() {

	// 	assertThat(pAndSAuthorRepository.findAll(Sort.by("lastName")))
	// 			.first()
	// 			.extracting("lastName")
	// 			.isEqualTo("rossi");

	// 	/* 
	// 	 *
	// 	 *  Direction.ASC di default
	// 	 *  - altrimenti inserire Sort.by(Direction.DESC, "lastName")
	// 	 * 
	// 	 */ 
	// 	assertThat(pAndSAuthorRepository.findAll(Sort.by("lastName")))
	// 			.extracting("lastName")
	// 			.contains("rossi", "Paccioretti");

	// 	assertThat(pAndSAuthorRepository.findAll(Sort.by("lastName")))
	// 			.extracting("lastName")
	// 			.contains("rossi", atIndex(0))
	// 			.contains("Paccioretti", atIndex(1));
	// }

	// @Test
	// void sorting2() {

	// 	Author a2 = new Author();
	// 	a2.setFirstname("Paolo");
	// 	a2.setLastname("rossi");
	// 	a2.setEmail("paolo@aulab.it");

	// 	entityManager.persist(a2);

	// 	assertThat(pAndSAuthorRepository.findAll(Sort.by("lastName", "firstname")))
	// 	.extracting("firstname")
	// 	.contains("Giorgio", atIndex(0))
	// 	.contains("Paolo", atIndex(1))
	// 	.contains("Jacopo", atIndex(2));
	// }

	// @Test
	// void paging() {

	// 	//authorRepository.deleteAll();

	// 	for (int i = 0; i < 100; i++) {
	// 		Author a = new Author();
	// 		a.setFirstname(String.valueOf(i));
	// 		a.setLastname(String.valueOf(i));
	// 		a.setEmail(String.valueOf(i));

	// 		authorRepository.save(a);
	// 	}

	// 	assertThat(authorRepository.findAll()).hasSize(100);

	// 	int pageSize = 10;
	// 	assertThat(pAndSAuthorRepository.findAll(PageRequest.of(0, pageSize)).getContent())
	// 			.extracting("firstname")
	// 			.contains("0", atIndex(0))
	// 			.contains("1", atIndex(1));

	// 	assertThat(pAndSAuthorRepository.findAll(PageRequest.of(1, pageSize)).getContent())
	// 		.extracting("lastName")
	// 		.contains("10", atIndex(0))
	// 		.contains("11", atIndex(1));

	// 	assertThat(pAndSAuthorRepository.findAll(PageRequest.of(9, pageSize)).getContent())
	// 	.extracting("email")
	// 	.contains("98", atIndex(8))
	// 	.contains("99", atIndex(9));
		

	// }

}
