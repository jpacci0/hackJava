package it.aulab.learningplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.learningplatform.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    
}
