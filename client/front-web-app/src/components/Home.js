import React from "react";
import {connect} from "react-redux";
import {APP_API_URL} from "../util/apiUtil";
import axios from "axios";

class Home extends React.Component{
    loadUsers = () => {
        axios.get(APP_API_URL+'/user').then(d=>console.log(d)).catch(e=>console.log(e))
    }

    componentDidMount() {
        this.loadUsers()
    }

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