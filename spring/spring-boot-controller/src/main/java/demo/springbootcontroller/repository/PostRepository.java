package demo.springbootcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import demo.springbootcontroller.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
    
    @Query("SELECT p FROM Post p WHERE P.author.firstname = 'Jacopo")
    List<Post> findByAuthorWithFirstNameJacopo();

}
