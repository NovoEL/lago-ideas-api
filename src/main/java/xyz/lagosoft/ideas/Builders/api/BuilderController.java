package xyz.lagosoft.ideas.Builders.api;

import xyz.lagosoft.ideas.Builders.service.FollowService;
import xyz.lagosoft.ideas.Builders.vo.BuilderProfileVO;
import xyz.lagosoft.ideas.Builders.vo.BuilderVO;
import xyz.lagosoft.ideas.Builders.dto.BuilderProfileDTO;
import xyz.lagosoft.ideas.Builders.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/builders")
public class BuilderController {

    @Autowired
    private BuilderService builderService;

    @Autowired
    private FollowService followService;

    @GetMapping
    public ResponseEntity<List<BuilderVO>> getAllUsers() {
        List<BuilderVO> users = builderService.retrieveAllBuilders();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{username}/profile")
    public ResponseEntity<BuilderProfileVO> getUserProfile(@PathVariable String username) {
        BuilderProfileVO profile = builderService.retrieveBuilderProfile(username);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PutMapping("/me/profile")
    public ResponseEntity<BuilderProfileVO> editUserProfile(@RequestBody BuilderProfileDTO request) {
        //TODO check permission
        BuilderProfileVO profile = builderService.updateBuilderProfile(request);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/{username}/followers")
    public ResponseEntity<Void> follow(@PathVariable String username) {
        followService.follow(username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
