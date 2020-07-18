import React from 'react';
import Dropzone from 'react-dropzone';
import {connect} from "react-redux";
import {addCreatePostImages, removeCreatePostImages} from "../../../store/post/actions";
import Grid from "@material-ui/core/Grid";


class PostImage extends React.Component {

    onDrop = (file) => {
        this.props.addCreatePostImages(file[0]);
    }

    onRemove = (id) => {
        this.props.removeCreatePostImages(id)
    }

    render() {
        return (
            <div>
                <div>
                    <Grid container>

                    {this.props.createPostImages.map((d) =>
                            <Grid item key={d.path}>
                                <div >
                                    <div onClick={() => this.onRemove(d.path)}>remove</div>
                                    <img src={URL.createObjectURL(d)} alt={d.path}/>
                                </div>
                            </Grid>
                    )}
                    </Grid>

                </div>
                <Dropzone onDrop={this.onDrop}>
                    {({getRootProps, getInputProps}) => (
                        <div {...getRootProps()}>
                            <input {...getInputProps()} />
                            Click me to upload a file!
                        </div>
                    )}
                </Dropzone>
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        createPostImages: state.createPost.createPostImages
    }
};

const mapDispatchToProps = {
    addCreatePostImages: addCreatePostImages,
    removeCreatePostImages: removeCreatePostImages,
};

export default connect(mapStateToProps, mapDispatchToProps)(PostImage);
