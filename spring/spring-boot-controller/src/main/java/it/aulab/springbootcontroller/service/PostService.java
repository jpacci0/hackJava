package it.aulab.springbootcontroller.service;

import java.util.List;

import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Post;

public interface PostService {
    List<PostDTO> readAll();
    List<Post> read(String title, String body);
    Post readOne(Long id) throws Exception;
    Post create(Post post);
    Post update(Long id, Post post) throws Exception;
    String delete(Long id) throws Exception;

    
    void transaction();
    void noTransaction();
}
