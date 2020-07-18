import React from "react";
import {connect} from "react-redux";
import {loadPosts} from "../../store/post/actions";
import {Container} from "@material-ui/core";
import ShortPost from "./shortpost/ShortPost";

class Home extends React.Component {

    componentDidMount() {
        this.props.loadPosts()
    }

    onViewClick = (id) => {
        this.props.history.push(`/post/${id}`)
    }

    render() {
        return (
            <Container maxWidth="lg">
                    {
                        this.props.postList.map(d => {
                            return d ?<ShortPost  key={d.id} post={d} onViewClick={this.onViewClick}/> : ""
                        })
                    }
            </Container>
        )
    }
}

const mapStateToProps = state => {
    return {
        postList: state.createPost.postList,
    }
};

const mapDispatchToProps = {
    loadPosts: loadPosts
};

export default connect(mapStateToProps, mapDispatchToProps)(Home)
