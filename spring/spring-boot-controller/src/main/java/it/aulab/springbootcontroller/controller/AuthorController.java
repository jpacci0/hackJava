package it.aulab.springbootcontroller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springbootcontroller.model.Author;
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

    @GetMapping("client")
    public String authorsViewClientSide(Model model) {
        model.addAttribute("title", "Authors");
        return "authors_csr";
    }

    @GetMapping("add")
    public String authorsAddView(Model model) {
        model.addAttribute("title", "Add Author");
        model.addAttribute("pippo", new Author());
        return "newAuthor";
    }

    @PostMapping("save")
    public String authorsSave(@ModelAttribute("pippo") Author author) throws Exception {
        authorService.create(author);
        return "redirect:/authors";
    }

    @GetMapping("modify/{id}")
    public String authorModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update Author");
        model.addAttribute("pluto", authorService.readOne(id));
        return "modifyAuthor";
    }

    @PostMapping("update")
    public String authorUpdate(@ModelAttribute("pluto") Author author) throws Exception {
        authorService.update(author.getId(), author);
        return "redirect:/authors";
    }

    @PostMapping("update/{id}")
    public String authorUpdateWithId(@PathVariable("id") Long id, @ModelAttribute("pluto") Author author) throws Exception {
        authorService.update(id, author);
        return "redirect:/authors";
    }


}
