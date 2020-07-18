import React from "react";
import {connect} from "react-redux";
import PostEditor from "./posteditor/PostEditor";
import {Container} from "@material-ui/core";
import PostImage from "./postimage/PostImage";
import Button from "@material-ui/core/Button";
import {savePost, setPostTitleText} from "../../store/post/actions";


class CreatePost extends React.Component{

    handleSubmit = () => {
        const formData = new FormData();
        for (let i = 0; i < this.props.createPostImages.length; i++) {
            formData.append(`file`,this.props.createPostImages[i])
        }

        formData.append("description", this.props.postDescription);
        formData.append("title", this.props.postTitle);

        this.props.savePost(formData);
    }

    render() {
        return (
            <Container maxWidth="md">
                <input
                    type={"text"}
                    value={this.props.postTitle}
                    onChange={(e)=>this.props.setPostTitle(e.target.value)}
                />
                <br/>
                <br/>
                <PostImage/>
                <PostEditor/>
                <Button
                    variant="contained"
                    color="primary"
                    margin="normal"
                    fullWidth
                    onClick={this.handleSubmit}
                >
                    Log in
                </Button>
                {/*<div className="content" dangerouslySetInnerHTML={{__html: this.props.postDescription}}></div>*/}
            </Container>
        );
    }
}

const mapStateToProps = state => {
    return {
        postDescription: state.createPost.postDescription,
        createPostImages: state.createPost.createPostImages,
        postTitle: state.createPost.postTitle
    }
};

const mapDispatchToProps = {
    setPostTitle: setPostTitleText,
    savePost: savePost,
};

export default connect(mapStateToProps, mapDispatchToProps)(CreatePost);
