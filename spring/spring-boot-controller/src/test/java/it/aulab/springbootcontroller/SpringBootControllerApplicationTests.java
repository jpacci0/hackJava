package it.aulab.springbootcontroller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.transaction.annotation.Transactional;

import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Comment;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.CommentRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.service.AuthorService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
// @DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class SpringBootControllerApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	AuthorService authorService;

	@BeforeEach
	public void createData() {

		commentRepository.deleteAll();
		postRepository.deleteAll();
		authorRepository.deleteAll();

		Author a1 = new Author();
		a1.setFirstName("Andrea");
		a1.setLastName("Mininni");
		a1.setEmail("andreamininni@aulab.it");

		authorRepository.save(a1);

		Author a2 = new Author();
		a2.setFirstName("Mirko");
		a2.setLastName("Abbrescia");
		a2.setEmail("mirkoabbrescia@aulab.it");

		authorRepository.save(a2);

		Post p1 = new Post();
		p1.setAuthor(a1);
		p1.setTitle("Il nuovo Pixel 7 Pro");
		p1.setBody("Lorem ipsum");
		p1.setPublishDate("20230411");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAuthor(a2);
		p2.setTitle("Il nuovo IPhone 14");
		p2.setBody("Lorem ipsum");
		p2.setPublishDate("20230411");

		postRepository.save(p2);

		Comment c1 = new Comment();
		c1.setEmail("andreamininni@aulab.it");
		c1.setPost(p1);
		c1.setBody("Non mi è piace");
		c1.setPublishDate("20230411");

		Comment c2 = new Comment();
		c2.setEmail("andreamininni@aulab.it");
		c2.setPost(p2);
		c2.setBody("Bellissimo, consigliato");
		c2.setPublishDate("20230412");

		Comment c3 = new Comment();
		c3.setEmail("mirkoabbrescia@aulab.it");
		c3.setPost(p2);
		c3.setBody("Bellissimo, consigliato");
		c3.setPublishDate("20230412");

		List<Comment> commentList = new ArrayList<Comment>();
		commentList.add(c1);
		commentList.add(c2);
		commentList.add(c3);

		commentRepository.saveAll(commentList);

	}

	@Test
	void customQuery1() {
		/*
		 *
		 * select p1_0.id,p1_0.author_id,p1_0.body,p1_0.publish_date,p1_0.title
		 * from posts p1_0
		 * join authors a1_0 on a1_0.id=p1_0.author_id
		 * where a1_0.firstname='Mirko'
		 *
		 */
		List<Post> posts = postRepository.findMirko();

		assertThat(posts).hasSize(1);
		assertThat(posts.get(0))
				.extracting("author")
				.extracting("firstName")
				.isEqualTo("Mirko");
	}

	@Test
	void customQuery2() {

		Author a = new Author();
		a.setFirstName("Andrea");
		a.setLastName("Ciccio");
		a.setEmail("andreaciccio@aulab.it");

		authorRepository.save(a);

		Post p = new Post();
		p.setAuthor(a);
		p.setTitle("Che bella giornata");
		p.setBody("Lorem ipsum");
		p.setPublishDate("20230411");

		postRepository.save(p);

		/*
		 *
		 * select p1_0.id,p1_0.author_id,p1_0.body,p1_0.publish_date,p1_0.title
		 * from posts p1_0
		 * join authors a1_0 on a1_0.id=p1_0.author_id
		 * where a1_0.firstname=?
		 *
		 */
		List<Post> posts = postRepository.findByAuthorFirstName("Andrea");

		assertThat(posts).hasSize(2);
		assertThat(posts)
				.extracting("author")
				.extracting("firstName")
				.contains("Andrea", "Andrea");
	}

	@Test
	void customQuery3() {
		/*
		 *
		 * select p1_0.id,p1_0.author_id,p1_0.body,p1_0.publish_date,p1_0.title
		 * from posts p1_0
		 * join authors a1_0 on a1_0.id=p1_0.author_id
		 * where a1_0.firstname=?
		 * and a1_0.lastname=?
		 *
		 */
		List<Post> posts = postRepository.findByAuthorFirstNameAndLastName("Mininni", "Andrea");

		assertThat(posts).hasSize(1);
		assertThat(posts)
				.first()
				.extracting("author")
				.extracting("firstName")
				.isEqualTo("Andrea");

		assertThat(posts.get(0))
				.extracting("author")
				.extracting("lastName")
				.isEqualTo("Mininni");
	}

	@Test
	void customQuery4() {
		assertThat(commentRepository.count()).isEqualTo(3);

		/*
		 *
		 * delete from comments
		 * where email like 'mirko%'
		 *
		 */
		commentRepository.deleteMirko();

		assertThat(commentRepository.count()).isEqualTo(2);
	}

	@Test
	void testTransaction() {
		try {
			// authorService.noTransaction();
			authorService.transaction();
		} catch (Exception e) {
			assertThat(postRepository.findByAuthorFirstNameAndLastName("null", "null")).hasSize(0);
			assertThat(authorRepository.findByFirstNameAndLastName("null", "null")).hasSize(0);
		}

	}

}
