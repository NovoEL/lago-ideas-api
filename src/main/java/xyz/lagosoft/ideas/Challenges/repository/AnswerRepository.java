package xyz.lagosoft.ideas.Challenges.repository;

import xyz.lagosoft.ideas.Challenges.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
