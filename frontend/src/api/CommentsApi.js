
import Api from "./Api";

class CommentsApi {
    getAllComments() {
        return Api.get('/comments');
    }

    getCommentsById(id) {
        return Api.get('/comments/'+id);
    }

    createComment(post) {
        return Api.post('/comments', post);
    }

    updateComment(post) {
        return Api.put('/comments', post);
    }

    deleteComment(id) {
        return Api.delete('/comments/'+id);
    } 
}

export default new CommentsApi();