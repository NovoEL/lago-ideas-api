package xyz.lagosoft.ideas.Projects.api;

import xyz.lagosoft.ideas.Projects.model.Stack;
import xyz.lagosoft.ideas.Projects.service.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/stacks")
public class StackController {

    @Autowired
    private StackService stackService;

    @GetMapping
    public ResponseEntity<List<Stack>> getAllStacks(){
        List<Stack> stacks = stackService.retrieveAllStacks();
        return new ResponseEntity<>(stacks, HttpStatus.OK);
    }

}
