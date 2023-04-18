package it.aulab.springbootcontroller.service;

import java.util.List;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Post;

public interface PostService {
    List<PostDTO> readAll();
    // List<PostDTO> read(String title, String body);
    PostDTO readOne(Long id) throws Exception;
    PostDTO create(CreatePostDTO post) throws Exception;
    PostDTO update(Long id, Post post) throws Exception;

    
}


// List<AuthorDTO> readAll();
//     List<AuthorDTO> read(String firstName, String lastName);
//     AuthorDTO readOne(Long id) throws Exception;
//     AuthorDTO create(Author author) throws Exception;
//     AuthorDTO update(Long id, Author author) throws Exception;
//     String delete(Long id) throws Exception;

    
//     void transaction();
//     void noTransaction();