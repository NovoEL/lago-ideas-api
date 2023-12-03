package xyz.lagosoft.ideas.Challenges.repository;

import xyz.lagosoft.ideas.Challenges.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
