package it.aulab.learningplatform.dto;

import java.util.List;

import it.aulab.learningplatform.model.Lesson;
import it.aulab.learningplatform.model.Student;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private String teacherFirstname;
    private String teacherLastname;
    private String date;
    private Integer numberOfStudents;
    private List<Lesson> lessons;
    private List<Student> students;
    // private List<LessonDTO> lessons;
    // private List<StudentDTO> students;
    public CourseDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getTeacherFirstname() {
        return teacherFirstname;
    }
    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }
    public String getTeacherLastname() {
        return teacherLastname;
    }
    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }
    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}

/* Questa è una classe DTO (Data Transfer Object) per rappresentare un corso. La classe ha una serie di attributi che rappresentano le informazioni principali del corso, come il nome, la descrizione, il nome e cognome del professore, la data in cui si tiene il corso, nonché una lista di lezioni e studenti associati al corso.

La classe fornisce anche i metodi getter e setter per accedere e modificare gli attributi dell'oggetto, consentendo quindi di trasferire i dati del corso tra il layer di presentazione e quello di business logic. */