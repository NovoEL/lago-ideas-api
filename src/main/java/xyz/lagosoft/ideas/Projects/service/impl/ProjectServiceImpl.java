package xyz.lagosoft.ideas.Projects.service.impl;

import xyz.lagosoft.ideas.Challenges.model.SDGSolutionChallenge;
import xyz.lagosoft.ideas.Challenges.repository.ChallengeRepository;
import xyz.lagosoft.ideas.Projects.dto.ChallengeEntryDTO;
import xyz.lagosoft.ideas.Projects.model.ChallengeEntry;
import xyz.lagosoft.ideas.Projects.model.SDG;
import xyz.lagosoft.ideas.Projects.repository.ChallengeEntryRepository;
import xyz.lagosoft.ideas.Projects.service.SDGService;
import xyz.lagosoft.ideas.Projects.dto.SideProjectDTO;
import xyz.lagosoft.ideas.Projects.model.SideProject;
import xyz.lagosoft.ideas.Projects.repository.SideProjectRepository;
import xyz.lagosoft.ideas.Projects.service.ProjectService;
import xyz.lagosoft.ideas.Projects.service.StackService;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import xyz.lagosoft.ideas.APIs.AwesomeAPI;
import xyz.lagosoft.ideas.APIs.APIService;
import xyz.lagosoft.ideas.Projects.model.Stack;
import xyz.lagosoft.ideas.Builders.model.Builder;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import xyz.lagosoft.ideas.common.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private SideProjectRepository projectRepository;

    @Autowired
    private ChallengeEntryRepository entryRepository;

    @Autowired
    private ChallengeRepository challengeRepository;

    @Autowired
    private BuilderService builderService;

    @Autowired
    private APIService apiService;

    @Autowired
    private StackService stackService;

    @Autowired
    private SDGService sdgService;

    public ProjectVO createSideProject(SideProjectDTO dto) {
        SideProject project = new SideProject();
        project.setChallengeEntry(Boolean.FALSE);
        BeanUtils.copyProperties(dto, project);
        Builder owner = builderService.getCurrentBuilder();
        project.setOwner(owner);
        List<Builder> coCreatorList = builderService.retrieveBuildersByUsernames(dto.getCoCreatorNameList());
        project.setCoCreators(Set.copyOf(coCreatorList));
        List<AwesomeAPI> apiList = apiService.retrieveAPIsBySlugs(dto.getAPISlugList());
        project.setAPIs(Set.copyOf(apiList));
        List<Stack> stackList = stackService.retrieveStacksBySlugs(dto.getStackSlugList());
        project.setStacks(Set.copyOf(stackList));
        project.setCreatedAt(new Date());
        projectRepository.save(project);
        owner.addOwnedProject(project);
        for (Builder builder : coCreatorList) {
            builder.addCoCreatedProject(project);
        }
        return new ProjectVO(project);
    }

    public ProjectVO createChallengeEntry(ChallengeEntryDTO dto) {
        SDGSolutionChallenge challenge = challengeRepository.findBySlug(dto.getChallengeSlug());
        ChallengeEntry entry = new ChallengeEntry();
        entry.setChallengeEntry(Boolean.TRUE);
        BeanUtils.copyProperties(dto, entry);
        Builder owner = builderService.getCurrentBuilder();
        entry.setOwner(owner);
        List<Builder> coCreatorList = builderService.retrieveBuildersByUsernames(dto.getCoCreatorNameList());
        entry.setCoCreators(Set.copyOf(coCreatorList));
        List<SDG> sdgList = sdgService.retrieveSDGsBySlugs(dto.getSDGSlugList());
        entry.setSDGs(Set.copyOf(sdgList));
        List<AwesomeAPI> apiList = apiService.retrieveAPIsBySlugs(dto.getAPISlugList());
        entry.setAPIs(Set.copyOf(apiList));
        List<Stack> stackList = stackService.retrieveStacksBySlugs(dto.getStackSlugList());
        entry.setStacks(Set.copyOf(stackList));
        entry.setCreatedAt(new Date());
        entryRepository.save(entry);
        owner.addOwnedProject(entry);
        for (Builder builder : coCreatorList) {
            builder.addCoCreatedProject(entry);
        }
        challenge.addEntry(entry);
        challengeRepository.save(challenge);
        return new ProjectVO(entry);
    }

    public List<ProjectVO> retrieveAllSideProjects() {
        return convertToProjectVOs(projectRepository.findAll());
    }

    public ProjectVO retrieveSideProject(Long id) {
        SideProject project = projectRepository.findById(id).orElseThrow(NotFoundException::new);
        return new ProjectVO(project);
    }

    private List<ProjectVO> convertToProjectVOs(List<SideProject> projects) {
        List<ProjectVO> projectVOs = new ArrayList<>();
        for (SideProject project : projects) {
            projectVOs.add(new ProjectVO(project));
        }
        return projectVOs;
    }

}
