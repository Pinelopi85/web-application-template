package se.kth.sda6.skeleton.Post.java;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.kth.sda6.skeleton.posts.Post;
import se.kth.sda6.skeleton.posts.PostController;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class SkeletonApplicationTests {
	@Autowired
	PostController postController;

	@Test
	void Post_CRUD_Test() {
		//Testing Create  Post
		List<Post> listOfPosts = postController.getAll();
		Post newPost = new Post();
		newPost.setBody("This is a test post");
		postController.create(newPost);
		List<Post> addOnePostToListOfPosts = postController.getAll();
		assertTrue(addOnePostToListOfPosts.size() - listOfPosts.size() == 1);

		//Testing Update Post
		Post updatedPost = postController.getById(newPost.getId());
		updatedPost.setBody("This is the updated post");
		postController.update(updatedPost);
		Post postFromDatabase = postController.getById(updatedPost.getId());
		assertEquals(updatedPost.getBody(), postFromDatabase.getBody());

		//Testing Delete Post
		postController.delete(newPost.getId());
		addOnePostToListOfPosts = postController.getAll();
		assertTrue(addOnePostToListOfPosts.size() - listOfPosts.size() == 0);
	}

}
