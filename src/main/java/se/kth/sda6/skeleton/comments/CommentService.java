package se.kth.sda6.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kth.sda6.skeleton.posts.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllByPost(Post post) {
        return commentRepository.findAllByPost(post);
    }

    public Optional<Comment> getByID(Long id) {
        return commentRepository.findById(id);
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    public void update(Comment comment) {
        commentRepository.save(comment);
    }
}
