import React from 'react';
import CommentsApi from './../../api/CommentsApi';
import CommentForm from './CommentForm';
import Comment from './Comment';

class CommentList extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            comments: []
        };
    }

    async getCommentByPostId() {
        try {
            let commentResponse = await CommentsApi.getCommentsByPostId(this.props.post.id);
            this.setState({
                comments: commentResponse.data
            });
        } catch (e) {
            console.error(e);
        }
    }

    async createComment(commentData) {
        Object.assign(commentData, { post: this.props.post })
        try {
            const response = await CommentsApi.createComment(commentData);
            const comment = response.data;
            const newComment = this.state.comments.concat(comment);
            this.setState({
                comments: newComment
            });
        } catch (e) {
            console.error(e);
        }
    }

    async deleteComment(comment) {
        try {
            await CommentsApi.deleteComment(comment.id);
            const newComment = this.state.comments.filter(p => p.id !== comment.id);
            this.setState({
                comments: newComment
            });
        } catch (e) {
            console.error(e);
        }
    }

    componentDidMount() {
        this.getCommentByPostId()
        CommentsApi.getAllComments()
            .then(({ data }) => this.setState({ comment: data }))
            .catch(err => console.error(err));
    }

    render() {
        const comments = this.state.comments;

        return (
            <div>
                <CommentForm onSubmit={(postData) => this.createComment(postData)} />
                {comments.map(post =>
                    <Comment key={post.id} post={post} onDeleteClick={() => this.deleteComment(post)} />
                )}
            </div>
        );
    }
}

export default CommentList;
