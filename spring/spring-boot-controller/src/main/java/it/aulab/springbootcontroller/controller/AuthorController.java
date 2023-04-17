package it.aulab.springbootcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springbootcontroller.service.AuthorService;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    
    /*
     * 
     * SPEL -> Spring Expression Language (SpEL)
     * 
     */
    @GetMapping
    public String authorsView(Model model) {
        model.addAttribute("title", "Authors");
        model.addAttribute("authors", authorService.readAll());
        return "authors";
    }


}
