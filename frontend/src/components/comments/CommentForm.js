import React from "react";

const CommentForm = ({ onSubmit }) => {
    const [body, setBody] = React.useState("");
    const handleSubmit = () => {
        //Passed in ev.callback
        onSubmit({ body: body });

        // Clear the input field
        setBody("");
    };

    return (
        <div className="comment">
            <div className="comment-body">
                <h5 className="comment-field" >Write a comment</h5>
                <div>
                    <div className="form-group">
                        <textarea
                            className="form-control"
                            value={body}
                            onChange={e => setBody(e.target.value)} />
                    </div>
                    <div className="form-group">
                        <button
                            className="btn btn-primary"
                            onClick={handleSubmit}>
                            Comment
                            </button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CommentForm;