import React from "react";

function Comment({post, onDeleteClick}) {
    return (
        <div className="comment mt-3">
            <div className="comment-body">
                <p>
                    {post.body}
                </p>

                <button className="btn btn-danger" onClick={onDeleteClick}>Delete</button>
            </div>
        </div>
    );
}

export default Comment;