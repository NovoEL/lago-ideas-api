package xyz.lagosoft.ideas.Challenges.repository;

import xyz.lagosoft.ideas.Challenges.model.ChallengeFollow;
import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeFollowRepository extends JpaRepository<ChallengeFollow, Long> {
    ChallengeFollow findFirstByChallengeAndBuilder(SDGSolutionChallenge challenge, Builder builder);
}
