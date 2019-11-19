package se.kth.sda6.skeleton.posts;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    @TODO Autowire the PostRepository and use it to implement all the service methods.
 */
@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> getAll() {
        // @TODO get all posts and return them as List<Post>
        return repository.findAll();
    }

    public Optional<Post> getById(Long id) {
        // @TODO get a post by ID if it exists
        return repository.findById(id);
    }

    public Post create(Post newPost) {
        // @TODO save the post to DB and return the saved post
        return repository.save(newPost);
    }

    public Post update(Post updatedPost) {
        // @TODO update the post if it exists in DB and return the updated post.
        return repository.save(updatedPost);
    }

    public void delete(Long id) {
        // @TODO delete the post by id
        repository.deleteById(id);
    }
}
