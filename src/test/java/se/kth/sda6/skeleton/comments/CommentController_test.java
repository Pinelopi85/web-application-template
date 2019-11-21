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
        ResponseEntity<?> listOfComments = commentController.getAll();
        List<Comment> initialListOfComments = (List<Comment>) listOfComments.getBody();
        Comment newComment = new Comment();
        newComment.setBody("Sounds cool");
        commentController.create(newComment);
        ResponseEntity<?> updatedListOfComments = commentController.getAll();
        List<Comment> addOneCommentToList = (List<Comment>) updatedListOfComments.getBody();
        assertTrue(addOneCommentToList.size() - initialListOfComments.size() == 1);

        //Testing update  comment
        Comment updatedComment = (Comment) commentController.getById(newComment.getId()).getBody();
        updatedComment.setBody("I changed my mind");
        commentController.update(updatedComment);
        Comment commentFromDatabase = (Comment) commentController.getById(updatedComment.getId()).getBody();
        assertEquals(updatedComment.getBody(), commentFromDatabase.getBody());

        //Testing delete comment
        commentController.delete(newComment.getId());
        updatedListOfComments = commentController.getAll();
        List<Comment> listAfterDeletion = (List<Comment>) updatedListOfComments.getBody();
        assertTrue(listAfterDeletion.size() - initialListOfComments.size() == 0);
    }
}


