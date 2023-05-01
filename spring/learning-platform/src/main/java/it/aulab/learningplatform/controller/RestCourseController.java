package it.aulab.learningplatform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.service.CrudService;

@RestController
@RequestMapping("api/courses")
public class RestCourseController {

    @Autowired
    // @Qualifier("courseService")
    private CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> courseService;

    // @Autowired
    // private CourseService courseServiceImpl;

    @GetMapping("all")
    public List<CourseDTO> getAll(@RequestParam Map<String, String> params) {
        return courseService.readAll();
    }

    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String, String> params) {
        return courseService.read(params);
    }

    @GetMapping("{id}")
    public CourseDTO getOne(@PathVariable("id") Long id) throws Exception {
        return courseService.readOne(id);
    }

    @PostMapping
    public CourseDTO postOne(@RequestBody CreateCourseDTO createCourseDTO) {
        return courseService.create(createCourseDTO);
    }

    /*
     * PUT -> modifica tutti i campi presenti nel body
     */
    @PutMapping("{id}")
    public CourseDTO putOne(@PathVariable("id") Long id, @RequestBody UpdateCourseDTO updateCourseDto)
            throws Exception {
        return courseService.update(id, updateCourseDto);
    }

    /*
     * PATCH -> modifica solo i campi presenti nel body
     */
    // @PatchMapping

    @DeleteMapping("{id}")
    public CourseDTO putOne(@PathVariable("id") Long id) throws Exception {
        return courseService.delete(id);
    }

}

/* Il RestCourseController è una classe che si occupa di gestire le richieste HTTP relative alle operazioni CRUD sui corsi e di restituire le risposte in formato JSON.

In particolare, la classe ha un'annotazione @RestController che indica che si tratta di un controller REST, ovvero un controller che gestisce le richieste HTTP e restituisce le risposte in formato JSON.

L'annotazione @RequestMapping indica il percorso di base per le richieste relative ai corsi (api/courses), mentre il metodo get() si occupa di gestire le richieste GET per ottenere tutti i corsi presenti nel sistema.

La classe ha due dipendenze: courseService, che è un'interfaccia di tipo CrudService che definisce i metodi CRUD per i corsi, e courseServiceImpl, che è una classe concreta che implementa l'interfaccia CourseService.

In particolare, courseService è iniettato tramite l'annotazione @Autowired, che indica a Spring di gestire l'istanziazione dell'oggetto. L'annotazione @Qualifier viene utilizzata per specificare quale implementazione di CrudService deve essere iniettata, nel caso in cui ci sia più di un'implementazione disponibile. In questo caso, però, l'annotazione è commentata, quindi Spring utilizza l'implementazione di default, che dovrebbe essere CourseService.

Infine, il metodo get() restituisce la lista di tutti i corsi presenti nel sistema, ottenuti tramite il metodo readAll() di courseService. */