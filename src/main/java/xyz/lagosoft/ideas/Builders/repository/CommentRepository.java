package xyz.lagosoft.ideas.Builders.repository;

import xyz.lagosoft.ideas.Builders.model.Comment;
import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByAuthor(Builder author);

}
