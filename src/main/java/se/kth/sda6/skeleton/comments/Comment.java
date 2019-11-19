package se.kth.sda6.skeleton.comments;


import se.kth.sda6.skeleton.posts.Post;

import javax.persistence.*;

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

    public Comment() {
    }

    public Comment(String body) {
        this.body = body;
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
}
