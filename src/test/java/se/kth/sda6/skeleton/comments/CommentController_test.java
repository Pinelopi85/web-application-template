package se.kth.sda6.skeleton.comments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class CommentController_test {
    @Autowired
    CommentController commentController;

    @Test
    void commentControllerCreateAndUpdateTrue(){
        //Testing create comment
        ResponseEntity<?> comments = commentController.getAll();
        List<Comment> initialList = (List<Comment>) comments.getBody();
        Comment newComment = new Comment();
        newComment.setBody("Sounds cool");
        commentController.create(newComment);

        //Testing update  comment
        ResponseEntity<?> updatedComments = commentController.getAll();
        List<Comment> updatedList = (List<Comment>) updatedComments.getBody();
        assertTrue(updatedList.size() - initialList.size() == 1);

        Comment updatedComment = (Comment) commentController.getById(newComment.getId()).getBody();
        updatedComment.setBody("I changed my mind");
        commentController.update(updatedComment);
        Comment commentFromDatabase = (Comment) commentController.getById(updatedComment.getId()).getBody();
        assertEquals(updatedComment.getBody(), commentFromDatabase.getBody());

        //Testing delete comment
        commentController.delete(newComment.getId());
        updatedComments = commentController.getAll();
        List<Comment> listAfterDeletion = (List<Comment>) updatedComments.getBody();
        assertTrue(listAfterDeletion.size() - initialList.size() == 0);
    }
}


