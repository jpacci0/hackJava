package it.aulab.learningplatform.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.learningplatform.dto.CourseDTO;
import it.aulab.learningplatform.dto.CreateCourseDTO;
import it.aulab.learningplatform.dto.UpdateCourseDTO;
import it.aulab.learningplatform.model.Course;
import it.aulab.learningplatform.repository.CourseRepository;
import it.aulab.learningplatform.util.exception.CourseNotFound;

@Service("courseService")
public class CourseService implements CrudService<CourseDTO, Long, CreateCourseDTO, UpdateCourseDTO> {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CourseDTO> readAll() {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for (Course c : courseRepository.findAll()) {
            dtos.add(mapper.map(c, CourseDTO.class));
        }
        return dtos;
    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        String nameFilter = params.get("name");
        String teacherFirstnameFilter = params.get("teacherFirstname");
        String teacherLastnameFilter = params.get("teacherLastname");

        List<Course> courses;

        if (nameFilter != null && teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(
                    nameFilter, teacherFirstnameFilter, teacherLastnameFilter);
        } else if (teacherFirstnameFilter != null && teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContainingAndTeacherLastnameContaining(
                    teacherFirstnameFilter, teacherLastnameFilter);
        } else if (teacherFirstnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherFirstnameContaining(nameFilter,
                    teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null && nameFilter != null) {
            courses = courseRepository.findByNameContainingAndTeacherLastnameContaining(nameFilter,
                    teacherLastnameFilter);
        } else if (nameFilter != null) {
            courses = courseRepository.findByNameContaining(nameFilter);
        } else if (teacherFirstnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContaining(teacherFirstnameFilter);
        } else if (teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherLastnameContaining(teacherLastnameFilter);
        } else {
            courses = courseRepository.findAll();
        }

        return courses.stream().map((c) -> mapper.map(c, CourseDTO.class)).toList();
    }

    @Override
    public CourseDTO readOne(Long id) throws Exception {
        return mapper.map(this.exists(id), CourseDTO.class);
    }

    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        Course course = mapper.map(createDTO, Course.class);
        courseRepository.save(course);
        return mapper.map(course, CourseDTO.class);
    }

    @Override
    public CourseDTO update(Long id, UpdateCourseDTO updateDTO) throws Exception {
        Course dbCourse = this.exists(id);
        dbCourse.setDescription(updateDTO.getDescription());
        dbCourse.setDate(LocalDate.parse(updateDTO.getDate()));
        courseRepository.save(dbCourse);
        return mapper.map(dbCourse, CourseDTO.class);
    }

    @Override
    public CourseDTO delete(Long id) throws Exception {
        Course course = this.exists(id);
        CourseDTO courseDto = mapper.map(course, CourseDTO.class);
        courseRepository.delete(course);
        return courseDto;
    }

    private Course exists(Long id) throws Exception {
        if (courseRepository.existsById(id)) {
            return courseRepository.findById(id).get();
        } else {
            throw new CourseNotFound();
        }
    }

}

/* La classe CourseService usa un'istanza di CourseRepository per eseguire le operazioni di accesso ai dati.

Il metodo readAll() recupera tutti i corsi dal database e li mappa in una lista di oggetti CourseDTO, utilizzando un'istanza di ModelMapper. */