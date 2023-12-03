package xyz.lagosoft.ideas.Projects.repository;

import xyz.lagosoft.ideas.Projects.model.ChallengeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeEntryRepository extends JpaRepository<ChallengeEntry, Long> {
}
