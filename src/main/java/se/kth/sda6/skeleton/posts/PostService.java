package se.kth.sda6.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    //get all posts and return them as List<Post>
    public List<Post> getAll() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }

    // get a post by ID if it exists
    public Optional<Post> getById(Long id) {
       return repository.findById(id);

    }

    public Post create(Post newPost) {
        return repository.save(newPost);
    }

    // update the post if it exists in DB and return the updated post.
    public Post update(Post updatedPost) {
        return repository.save(updatedPost);
    }

    // delete the post by id
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}



