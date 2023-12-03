package xyz.lagosoft.ideas.Projects.service.impl;

import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.model.Support;
import xyz.lagosoft.ideas.Projects.repository.SideProjectRepository;
import xyz.lagosoft.ideas.Projects.repository.SupportRepository;
import xyz.lagosoft.ideas.Projects.service.SupportService;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SupportServiceImpl implements SupportService {
    @Autowired
    private SupportRepository supportRepository;
    @Autowired
    private SideProjectRepository projectRepository;
    @Autowired
    private BuilderService builderService;

    public void support(Long id) {
        SideProject project = projectRepository.findById(id).orElseThrow(NotFoundException::new);
        Builder builder = builderService.getCurrentBuilder();
        Optional<Support> supportOptional = Optional.ofNullable(supportRepository.findFirstByProjectAndBuilder(project, builder));
        if (supportOptional.isEmpty()) {
            Support support = new Support(project, builder);
            supportRepository.save(support);
            project.addSupporter(support);
            builder.addSupporting(support);
            return;
        }
        Support support = supportOptional.get();
        project.removeSupporter(support);
        builder.removeSupporting(support);
        supportRepository.delete(support);
    }

}
