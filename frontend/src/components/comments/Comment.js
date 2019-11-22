import React from "react";

function Comment({post, onDeleteClick}) {
    return (
        <div className="comment mt-3">
            <div className="comment-body">
                <p>
                    {post.body} <button className="btn btn-link" onClick={onDeleteClick}>Delete</button>
                </p>
            </div>
        </div>
    );
}

export default Comment;