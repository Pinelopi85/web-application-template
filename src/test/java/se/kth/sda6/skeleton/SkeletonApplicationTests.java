package se.kth.sda6.skeleton;

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
		List<Post> posts = postController.getAll();
		Post newPost = new Post();
		newPost.setBody("This is a test post");
		postController.create(newPost);
		//Testing Update Post
		List<Post> updatedPosts = postController.getAll();
		assertTrue(updatedPosts.size() - posts.size() == 1);
		Post updatedPost = postController.getById(newPost.getId());
		updatedPost.setBody("This is the updated post");
		postController.update(updatedPost);
		Post postFromDatabase = postController.getById(updatedPost.getId());
		assertEquals(updatedPost.getBody(), postFromDatabase.getBody());
		//Testing Delete Post
		postController.delete(newPost.getId());
		updatedPosts = postController.getAll();
		assertTrue(updatedPosts.size() - posts.size() == 0);
	}

}
