package xyz.lagosoft.ideas.Builders.repository;

import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuilderRepository extends JpaRepository<Builder, Long> {
    Builder findByUsername(String username);
}
