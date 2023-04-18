package it.aulab.springbootcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springbootcontroller.dto.CreatePostDTO;
import it.aulab.springbootcontroller.model.Post;
import it.aulab.springbootcontroller.service.AuthorService;
import it.aulab.springbootcontroller.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;
    
    @GetMapping
    public String postsView(Model model) {
        model.addAttribute("title", "Posts");
        model.addAttribute("posts", postService.readAll());
        return "posts";
    }

    @GetMapping("add")
    public String postsAddView(Model model) {
        model.addAttribute("title", "Add Post");
        model.addAttribute("pippo", new CreatePostDTO());
        model.addAttribute("paperini", authorService.readAll());
        return "newPost";
    }

    @PostMapping("save")
    public String postsSave(@ModelAttribute("pippo") CreatePostDTO createPostDTO) throws Exception {
        postService.create(createPostDTO);
        return "redirect:/posts";
    }

    @GetMapping("modify/{id}")
    public String postModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update Post");
        model.addAttribute("pluto", postService.readOne(id));
        return "modifyPost";
    }

    @PostMapping("update")
    public String postUpdate(@ModelAttribute("pluto") Post post) throws Exception {
        postService.update(post.getId(), post);
        return "redirect:/posts";
    }

    @PostMapping("update/{id}")
    public String postUpdateWithId(@PathVariable("id") Long id, @ModelAttribute("pluto") Post post) throws Exception {
        postService.update(id, post);
        return "redirect:/posts";
    }


}
