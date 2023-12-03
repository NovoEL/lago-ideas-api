package xyz.lagosoft.ideas.Builders.api;

import xyz.lagosoft.ideas.Builders.dto.CommentDTO;
import xyz.lagosoft.ideas.Builders.service.CommentService;
import xyz.lagosoft.ideas.Builders.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> newComment(@RequestBody CommentDTO request){
        commentService.createComment(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(params = "username")
    public ResponseEntity<List<CommentVO>> getCommentsByAuthor(@RequestParam String username) {
        List<CommentVO> comments = commentService.retrieveCommentsByAuthor(username);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editComment(@PathVariable Long id, @RequestBody CommentDTO request) {
        //TODO check permission
        commentService.updateComment(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        //TODO check permission
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
