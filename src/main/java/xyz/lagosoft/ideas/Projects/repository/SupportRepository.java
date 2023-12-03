package xyz.lagosoft.ideas.Projects.repository;

import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.model.Support;
import xyz.lagosoft.ideas.Builders.model.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long> {
    Support findFirstByProjectAndBuilder(SideProject project, Builder builder);
}
