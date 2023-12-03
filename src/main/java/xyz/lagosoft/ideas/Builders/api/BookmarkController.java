package xyz.lagosoft.ideas.Builders.api;

import xyz.lagosoft.ideas.Builders.dto.BookmarkDTO;
import xyz.lagosoft.ideas.Builders.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<Void> bookmark(@RequestBody BookmarkDTO request) {
        bookmarkService.bookmark(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
