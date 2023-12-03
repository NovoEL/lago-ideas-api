package xyz.lagosoft.ideas.APIs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwesomeAPIRepository extends JpaRepository<AwesomeAPI, Long> {
    AwesomeAPI findBySlug(String slug);

}
