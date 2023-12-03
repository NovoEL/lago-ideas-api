package xyz.lagosoft.ideas.Projects.repository;

import xyz.lagosoft.ideas.Projects.model.SideProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SideProjectRepository extends JpaRepository<SideProject, Long> {
}
