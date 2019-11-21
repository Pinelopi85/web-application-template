package se.kth.sda6.skeleton.comments;


import se.kth.sda6.skeleton.posts.Post;
import se.kth.sda6.skeleton.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a comment made by a user on a post.
 */
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "body")
    private String body;

    @ManyToOne()
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(Long id, String body, Post post, User user) {
        this.id = id;
        this.body = body;
        this.post = post;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    public void addComment(Comment comment) {
        comments.add( comment );
        comment.setPost( this.post );
    }

    public void removeComment(Comment comment) {
        comments.remove( comment );
        comment.setPost( null );
    }

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

}
