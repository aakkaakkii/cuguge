import React from "react";
import {connect} from "react-redux";

class Home extends React.Component{
    render() {
        return(
            <div>
                home
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
    }
};

const mapDispatchToProps = {};

export default connect(mapStateToProps, mapDispatchToProps)(Home);