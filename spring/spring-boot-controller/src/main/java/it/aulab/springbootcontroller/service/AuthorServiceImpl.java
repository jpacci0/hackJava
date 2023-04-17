package it.aulab.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;
// import java.util.Map;
// import java.util.HashMap;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.util.exception.AuthorNotFound;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

	@Autowired
	ModelMapper modelMapper;

    @Override
	@Transactional
	public void transaction() {
		Author a = new Author();
		a.setFirstName("null");
		a.setLastName("null");
		a.setEmail("null");

		a = authorRepository.save(a);

		Post p1 = new Post();
		p1.setAuthor(a);
		p1.setBody("Lorem ipsum");
		p1.setTitle("Lorem ipsum");
		p1.setPublishDate("20230514");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAuthor(a);
		p2.setBody("Lorem ipsum 2");
		p2.setPublishDate("20230514");

		postRepository.save(p2);
	}

    @Override
	public void noTransaction() {
		Author a = new Author();
		a.setFirstName("null");
		a.setLastName("null");
		a.setEmail("null");

		a = authorRepository.save(a);

		Post p1 = new Post();
		p1.setAuthor(a);
		p1.setBody("Lorem ipsum");
		p1.setTitle("Lorem ipsum");
		p1.setPublishDate("20230514");

		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAuthor(a);
		p2.setBody("Lorem ipsum 2");
		p2.setPublishDate("20230514");

		postRepository.save(p2);
	}

	@Override
	public List<AuthorDTO> readAll() {
		List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();

		for (Author author: authorRepository.findAll()) {
			dtos.add(modelMapper.map(author, AuthorDTO.class));
		}

		return dtos;
	}

	@Override
	public List<Author> read(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return authorRepository.findByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            return authorRepository.findByFirstName(firstName);
        } else if (lastName != null) {
            return authorRepository.findByLastName(lastName);
        } else {
            return authorRepository.findAll();
        }
	}

	@Override
	public Author readOne(Long id) throws Exception {
		Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        throw new AuthorNotFound();
	}

	// ESEMPIO con DynamicQuery
	// @Override
	// public List<Author> read(String firstName, String lastName) {
	// 	Map<String, String> fieldMapping = new HashMap<String, String>();
	// 	fieldMapping.put("firstName", firstName);
	// 	fieldMapping.put("lastName", lastName);
    //     return authorRepository.dynamicQuery(fieldMapping);
	// }

	@Override
	public Author create(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public Author update(Long id, Author author) throws Exception {
        Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        if (dbOptionalAuthor.isPresent()) {
            Author dbAuthor = dbOptionalAuthor.get();
            dbAuthor.setFirstName(author.getFirstName());
            dbAuthor.setLastName(author.getLastName());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);
            return dbAuthor;
        }
        throw new AuthorNotFound();
	}

	@Override
	public String delete(Long id) throws Exception {
		if (authorRepository.findById(id).isPresent()) {
			authorRepository.deleteById(id);
			return "OK";
		}
        throw new AuthorNotFound();
	}
    
}
