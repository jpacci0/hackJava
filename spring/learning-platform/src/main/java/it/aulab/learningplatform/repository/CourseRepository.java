package it.aulab.learningplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByNameContaining(String name);

    List<Course> findByTeacherFirstnameContaining(String teacherFirstname);

    List<Course> findByNameContainingAndTeacherFirstnameContaining(String name, String teacherFirstname);

    List<Course> findByTeacherLastnameContaining(String teacherFirstname);

    List<Course> findByNameContainingAndTeacherLastnameContaining(String name, String teacherFirstname);

    List<Course> findByTeacherFirstnameContainingAndTeacherLastnameContaining(String firstname, String teacherFirstname);

    List<Course> findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(String name, String firstname,
            String teacherFirstname);

}

/* Queste tre interfacce definiscono i repository per le rispettive entità Course, Lesson e Student. Ciascuna interfaccia estende l'interfaccia JpaRepository fornita da Spring Data JPA, che fornisce già i metodi base per l'accesso ai dati, come ad esempio save(), findById(), findAll(), deleteById(), ecc.

Tuttavia, se necessario, è possibile aggiungere altri metodi personalizzati ai repository definendo i nomi dei metodi secondo la convenzione di denominazione di Spring Data JPA. Ad esempio, se volessimo cercare tutti gli studenti iscritti a un determinato corso, potremmo definire un metodo findByCoursesId() nel repository StudentRepository. */