package it.aulab.springbootcontroller.service;

import java.util.List;

import it.aulab.springbootcontroller.dto.AuthorDTO;
import it.aulab.springbootcontroller.model.Author;

public interface AuthorService {
    List<AuthorDTO> readAll();
    List<AuthorDTO> read(String firstName, String lastName);
    AuthorDTO readOne(Long id) throws Exception;
    AuthorDTO create(Author author) throws Exception;
    AuthorDTO update(Long id, Author author) throws Exception;
    String delete(Long id) throws Exception;

    
    void transaction();
    void noTransaction();
}
