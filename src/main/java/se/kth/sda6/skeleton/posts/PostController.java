package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    // Get a list of all posts
    public List<Post> getAll ()
    {
        return postService.getAll();
    }

    // Get a specific post by it's id
    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // Create a new post
    @PostMapping("")
    public Post create(@RequestBody Post newPost)
    {
        return postService.create(newPost);

    }

    //  Update post
    @PutMapping("")
    public Post update(@RequestBody Post updatedPost)
    {
        return postService.update(updatedPost);
    }

    // Delete a specific post
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        postService.deleteById(id);
    }
}



