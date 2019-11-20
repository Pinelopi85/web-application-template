   import React from "react";

     function CommentForm({onSubmit}) {
        const [body, setBody] = React.useState("");
    
        const handleSubmit = () => {
            //Passed in ev.callback
            onSubmit({body: body});
    
            // Clear the input field
            setBody("");
        };
    
        return (
            <div className="comment">
                <div className="comment-body">
                    <h4 className="comment-field" >Write a comment</h4>
                    <div>
                        <div className="form-elements">
                            <textarea 
                                className="form-control"
                                value={body}
                                onChange={e => setBody(e.target.value)} />
                        </div>
    
    
                        <div className="form-elements">
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