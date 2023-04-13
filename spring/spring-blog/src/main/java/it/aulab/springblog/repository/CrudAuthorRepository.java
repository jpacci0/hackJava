package it.aulab.springblog.repository;

import org.springframework.data.repository.ListCrudRepository;

import it.aulab.springblog.model.Author;

public interface CrudAuthorRepository extends ListCrudRepository<Author, Long> {

}



