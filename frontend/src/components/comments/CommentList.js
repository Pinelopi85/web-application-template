import React from "react";
import CommentsApi from "./../../api/CommentsApi";
import CommentForm from "./CommentForm";
import Comment from "./Comment";

class CommentForm extends React.Component{
    constructor (props){
        super(props);

        this.state ={
            comments : []
        };
    }

    async createComment(commentData) {
        try {
            const response = await CommentsApi.createComment(commentData);
            const comment = response.data;
            const newComment = this.state.comments.concat(st);

            this.setState({
                comments: newComments,
            });
        } catch (e) {
            console.error(e);
        }
    }

    async deleteComment(comment) {
        try {
            await CommentsApi.deleteComment(comment.id);
            const newComments = this.state.comments.filter(p => p.id !== comments.id);
            this.setState({
                comments: newComments,
            });
        } catch (e) {
            console.error(e);
        }
    }

    componentDidMount() {
        CommentsApi.getAllComments()
            .then(({data}) => this.setState({comments: data}))
            .catch(err => console.error(err));
    }

    render() {
        const comments = this.state.comments;

        return (
            <div>
                <CommentForm onSubmit={(postData) => this.createComment(postData)}/>

                {comments.map(post => 
                    <CommentForm key={post.id} post={post} onDeleteClick={() => this.deletePost(post)}/>
                )}
            </div>
        );
    }
}