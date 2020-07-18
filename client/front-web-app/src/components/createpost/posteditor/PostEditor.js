import React from "react";
import {connect} from "react-redux";
import { Editor } from '@tinymce/tinymce-react';
import {setPostDescriptionText} from "../../../store/post/actions";

class PostEditor extends React.Component{
    handleEditorChange = (content, editor) => {
        this.props.setPostDescriptionText(content);
    }

    render() {
        return (
            <Editor
                apiKey="nbrgmxovk9ki6kvln0f9d5th01g0ecwinvvynsfoblvfmjyb"
                initialValue=""
                init={{
                    height: 500,
                    menubar: false,
                    plugins: [
                        'advlist autolink lists link image charmap print preview anchor',
                    ],
                    toolbar:
                        'undo redo | formatselect | bold italic backcolor | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent '
                }}
                onEditorChange={this.handleEditorChange}
            />
        );
    }
}

const mapStateToProps = state => {
    return {
        postDescription: state.createPost.postDescription
    }
};

const mapDispatchToProps = {
    setPostDescriptionText: setPostDescriptionText
};

export default connect(mapStateToProps, mapDispatchToProps)(PostEditor);
