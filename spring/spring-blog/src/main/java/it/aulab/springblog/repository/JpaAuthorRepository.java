package it.aulab.springblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springblog.model.Author;

public interface JpaAuthorRepository extends JpaRepository<Author, Long> {
     
    // public List<Author> findByLastName(String lastname);

    // public List<Author> findByFirstNameNotIgnoreCase(String s);

    // public List<Author> findByFirstNameEquals(String s);

    // public List<Author> findByFirstNameContains(String s);

    // public List<Author> findByFirstNameAndLastName(String a, String b);

    // public List<Author> findByFirstNameOrLastName(String a, String b);

}

