package it.aulab.springbootcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springbootcontroller.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {

    @Autowired
    private PostService postService;
    
    /*
     * 
     * SPEL -> Spring Expression Language (SpEL)
     * 
     */
    @GetMapping
    public String postsView(Model model) {
        model.addAttribute("title", "Posts");
        model.addAttribute("posts", postService.readAll());
        return "posts";
    }


}
