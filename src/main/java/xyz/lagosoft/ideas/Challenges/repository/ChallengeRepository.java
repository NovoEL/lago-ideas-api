package xyz.lagosoft.ideas.Challenges.repository;

import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<SDGSolutionChallenge, Long> {
    SDGSolutionChallenge findBySlug(String slug);
}
