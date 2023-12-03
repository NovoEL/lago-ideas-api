package xyz.lagosoft.ideas.Projects.api;

import xyz.lagosoft.ideas.Projects.model.SDG;
import xyz.lagosoft.ideas.Projects.service.SDGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/sdgs")
public class SDGController {

    @Autowired
    private SDGService sdgService;

    @GetMapping
    public ResponseEntity<List<SDG>> getAllSDGs(){
        List<SDG> sdgs = sdgService.retrieveAllSDGs();
        return new ResponseEntity<>(sdgs, HttpStatus.OK);
    }

}
