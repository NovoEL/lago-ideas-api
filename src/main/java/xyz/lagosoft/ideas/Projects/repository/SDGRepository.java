package xyz.lagosoft.ideas.Projects.repository;

import xyz.lagosoft.ideas.Projects.model.SDG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SDGRepository extends JpaRepository<SDG, Long> {
    SDG findBySlug(String slug);
}
