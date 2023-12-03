package xyz.lagosoft.ideas.Projects.repository;

import xyz.lagosoft.ideas.Projects.model.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Long> {
    Stack findBySlug(String slug);
}
