package it.aulab.springbootcontroller.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.service.PostService;
import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Post;

@RestController
@RequestMapping(value = "api/posts")
public class PostRestController {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for (Post p: postRepository.findAll()) {
            PostDTO map = modelMapper.map(p, PostDTO.class);
            dtos.add(map);
        }

        return dtos;
    }

    // /posts -> POST
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostDTO post(@RequestBody CreatePostDTO createPostDto) {
        Post post = modelMapper.map(createPostDto, Post.class);
        post = postRepository.save(post);
        /*
         *
         *  Workaround fatto a lezione funziona solo se spring.jpa.open-in-view=false
         *  post = postRepository.findById(post.getId()).get();
         * 
         *  Il Workaround qui sotto funziona meglio perché mi lascia l'anti-pattern
         *  di cui facciamo uso in Jackson (spring.jpa.open-in-view), altrimenti non 
         *  vi funziona la serializzazione delle relazioni mappedBy
         *  
         */ 
        post.setAuthor(authorRepository.findById(post.getAuthor().getId()).get());
        return modelMapper.map(post, PostDTO.class);
    }

    // rotta parametrica -> "/authors/:id" PUT
    // @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @PutMapping("/posts/{id}")
    public PostDTO put(@PathVariable("id") Long id, @RequestBody Post post) throws Exception {
        return postService.update(id, post);
    }

    // rotta parametrica -> "/authors/:id" DELETE
    // @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    // @DeleteMapping("{id}")
    // public String delete(@PathVariable("id") Long id) throws Exception {
    //     return postService.delete(id);
    // }

}
