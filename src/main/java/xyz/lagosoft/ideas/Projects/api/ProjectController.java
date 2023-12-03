package xyz.lagosoft.ideas.Projects.api;

import xyz.lagosoft.ideas.Projects.dto.SideProjectDTO;
import xyz.lagosoft.ideas.Projects.dto.UpdateDTO;
import xyz.lagosoft.ideas.Projects.service.ProjectService;
import xyz.lagosoft.ideas.Projects.service.SupportService;
import xyz.lagosoft.ideas.Projects.service.UpdateService;
import xyz.lagosoft.ideas.Projects.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private SupportService supportService;

    @PostMapping
    public ResponseEntity<Void> newSideProject(@RequestBody SideProjectDTO request){
        projectService.createSideProject(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/updates")
    public ResponseEntity<Void> newUpdate(@PathVariable Long id, @RequestBody UpdateDTO request) {
        ProjectVO project = projectService.retrieveSideProject(id);
        request.setProjectId(id);
        updateService.createUpdate(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}/supporters")
    public ResponseEntity<Void> support(@PathVariable Long id) {
        supportService.support(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectVO>> getAllSideProjects() {
        List<ProjectVO> projectVOs = projectService.retrieveAllSideProjects();
        return new ResponseEntity<>(projectVOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectVO> getSideProject(@PathVariable Long id) {
        ProjectVO projectVO = projectService.retrieveSideProject(id);
        return new ResponseEntity<>(projectVO, HttpStatus.OK);
    }

}
