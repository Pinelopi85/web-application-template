package se.kth.sda6.skeleton.posts;

import se.kth.sda6.skeleton.comments.Comment;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // The DB will handle the process of generating the id.
    private Long id;

    @NotEmpty
    @Column(name = "body")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post() {
    }

    public Post(Long id, String body
    ) {
        this.id = id;
        this.body = body;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
