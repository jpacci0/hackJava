package demo.springbootcontroller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import demo.springbootcontroller.repository.PostRepository;

@SpringBootTest
class SpringBootControllerApplicationTests {

	// @Autowired
	// AuthorRepository authorRepository;

	@Autowired
	PostRepository postRepository;

	@BeforeEach
	public void createData() {
		Author a1 = new Author();
		a1.setFirstName("Andrea");
		a1.setLastName("Mininni");
		a1.setEmail("mirkoabbrescia@aulab.it");

		authorRepository.save();

		Author a2 = new Author();
		a2.setFirstName("Mirko");
		a2.setLastName("abbrescia");
		a2.setEmail("andreamininni@aulab.it");

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
		c1.setEmail("andreamininni@aulab.it");
		c1.setPost(p1);
		c1.setBody("Non mi è piace");
		c1.setPublishDate("20230411");

		Comment c2 = new Comment();
		c2.setEmail("andreamininni@aulab.it");
		c2.setPost(p1);
		c2.setBody("Bellissimo, consigliato");
		c1.setPublishDate("20230412");

		entityManager.persist(c1);
		entityManager.persist(c2);
	}

	@Test
	void contextLoads() {

	}

}
