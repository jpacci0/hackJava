package it.aulab.springbootcontroller.service;

import java.util.List;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;

public interface AuthorService {
    List<AuthorDTO> readAll();
    List<Author> read(String firstName, String lastName);
    Author readOne(Long id) throws Exception;
    Author create(Author author);
    Author update(Long id, Author author) throws Exception;
    String delete(Long id) throws Exception;

    
    void transaction();
    void noTransaction();
}
