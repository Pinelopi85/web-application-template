package se.kth.sda6.skeleton.comments;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.kth.sda6.skeleton.posts.Post;
import se.kth.sda6.skeleton.posts.PostService;

import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getAll() {
        List<Comment> comments = commentService.getAll();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping(value = "/comments", params = "postId")
    public ResponseEntity<?> getAllOnPost(@RequestParam Long postId) {
        Post post = postService.getByID(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Comment> comments = commentService.getAllByPost(post);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Comment comment = commentService.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("comments")
    public ResponseEntity<?> create(@RequestBody Comment comment) {
        Comment newComment = commentService.create(comment);
        return new ResponseEntity<Comment>(newComment, HttpStatus.CREATED);
    }

    @PutMapping("comments")
    public ResponseEntity<?> update(@RequestBody Comment comment) {
        commentService.update(comment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        commentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
