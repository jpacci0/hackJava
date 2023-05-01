package it.aulab.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
