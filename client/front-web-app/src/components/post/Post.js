import React from 'react';
import {connect} from "react-redux";
import {getPost} from "../../store/post/actions";
import classes from "./Post.css";

class Post extends React.Component {

    componentDidMount() {
        this.props.getPost(this.props.match.params.id)
    }

    render() {
        return (
            <div>
                {this.props.post &&
                <div>
                    <div>{this.props.post.title}</div>
                    <div dangerouslySetInnerHTML={{__html: this.props.post.description}}/>
                    <div><img src={this.props.post.images && this.props.post.images[0]} alt={this.props.post.title}/>
                    </div>
                    <br/>
                    <br/>
                </div>
                }
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        post: state.createPost.post
    }
};

const mapDispatchToProps = {
    getPost: getPost,
};

export default connect(mapStateToProps, mapDispatchToProps)(Post);
