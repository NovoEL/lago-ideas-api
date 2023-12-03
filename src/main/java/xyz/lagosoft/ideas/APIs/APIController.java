package xyz.lagosoft.ideas.APIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/apis")
public class APIController {

    @Autowired
    private APIService apiService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<AwesomeAPI>> getAllAPIs(){
        List<AwesomeAPI> apis = apiService.retrieveAllAPIs();
        return new ResponseEntity<>(apis, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryVO>> getAllAPICategories(){
        List<CategoryVO> categories = categoryService.retrieveAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/categories/{slug}")
    public ResponseEntity<List<AwesomeAPI>> getAPIsByCategory(@PathVariable String slug){
        List<AwesomeAPI> apis = apiService.retrieveAPIsByCategory(slug);
        return new ResponseEntity<>(apis, HttpStatus.OK);
    }

    @GetMapping("/{slug}/categories")
    public ResponseEntity<CategoryVO> getAPICategory(@PathVariable String slug) {
        CategoryVO category = categoryService.retrieveCategory(slug);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("/{slug}")
    public ResponseEntity<AwesomeAPI> getAPI(@PathVariable String slug) {
        AwesomeAPI api = apiService.retrieveAPI(slug);
        return new ResponseEntity<>(api, HttpStatus.OK);
    }

}
