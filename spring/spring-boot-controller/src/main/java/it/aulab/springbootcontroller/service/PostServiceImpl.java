package it.aulab.springbootcontroller.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.dto.PostDTO;
import it.aulab.springbootcontroller.model.Author;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.repository.AuthorRepository;
import it.aulab.springbootcontroller.repository.PostRepository;
import it.aulab.springbootcontroller.util.exception.AuthorNotFound;
import it.aulab.springbootcontroller.util.exception.PostNotFound;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PostDTO> readAll() {
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p: postRepository.findAll()) {
            dtos.add(modelMapper.map(p, PostDTO.class));
        }

        return dtos;
    }

    @Override
	public PostDTO readOne(Long id) throws Exception {
		Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            return modelMapper.map(optionalPost.get(), PostDTO.class);
        }
        throw new PostNotFound();
	}

    @Override
    public PostDTO create(CreatePostDTO createPostDTO) throws Exception {
        Post p = modelMapper.map(createPostDTO, Post.class);
        postRepository.save(p);
        Optional<Author> optionalAuthor = authorRepository.findById(createPostDTO.getAuthorId());
        if (optionalAuthor.isPresent()) {
            p.setAuthor(optionalAuthor.get());
            return modelMapper.map(p, PostDTO.class);
        }
        throw new AuthorNotFound();
    }

    @Override
    public PostDTO update(Long id, Post post) throws Exception {
        Optional<Post> dbOptionalPost = postRepository.findById(id);
        if (dbOptionalPost.isPresent()) {
            Post dbPost = dbOptionalPost.get();
            dbPost.setTitle(post.getTitle());
            dbPost.setBody(post.getBody());
            dbPost.setPublishDate(post.getPublishDate());
            postRepository.save(dbPost);
            return modelMapper.map(dbPost, PostDTO.class);
        }
        throw new PostNotFound();
    }
  
    
}
