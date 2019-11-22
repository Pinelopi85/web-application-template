import React from "react";
import CommentList from '../comments/CommentList';

function PostCard({ post, onDeleteClick }) {
    return (
        <div className="card mt-3">
            <div className="card-body">
                <p>
                    {post.body}
                    <button className="btn btn-link" onClick={onDeleteClick}>Delete</button>
                </p>
                <div>
                    <CommentList post={post} />
                </div>
            </div>
        </div>
    );
}

export default PostCard;