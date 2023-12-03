package xyz.lagosoft.ideas.Projects.service;

import xyz.lagosoft.ideas.Projects.dto.ChallengeEntryDTO;
import xyz.lagosoft.ideas.Projects.dto.SideProjectDTO;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;

import java.util.List;

public interface ProjectService {

    ProjectVO createSideProject(SideProjectDTO dto);

    ProjectVO createChallengeEntry(ChallengeEntryDTO dto);

    List<ProjectVO> retrieveAllSideProjects();

    ProjectVO retrieveSideProject(Long id);

}
