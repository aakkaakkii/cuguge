import React from "react";
import {connect} from "react-redux";
import {setPasswordText, setUsernameText} from "../../store/login/actions";
import {Button, Container, TextField, Typography} from "@material-ui/core";
import GoogleLogin from "react-google-login";
import FacebookLogin from 'react-facebook-login';
import {googleAuth} from "../../api/security/login";
import {Link} from "react-router-dom";


class Login extends React.Component {
    onUsernameChange = (event) => {
        this.props.setUsernameText(event.target.value);
    }

    onPasswordChange = (event) => {
        this.props.setPasswordText(event.target.value);
    }

    responseGoogle = (response) => {
        //TODO: change
        googleAuth(response.tokenId);
    }

    /*

        responseGoogle = (response) =>{
            console.log(response);
        }
    */

    render() {
        return (
            <Container maxWidth="xs">
                <TextField
                    type='text'
                    variant="outlined"
                    label="Enter Username"
                    name='username'
                    margin="normal"
                    fullWidth
                    value={this.props.username}
                    onChange={this.onUsernameChange}
                />
                <TextField
                    type='password'
                    variant="outlined"
                    label="Enter Username"
                    name='password'
                    margin="normal"
                    fullWidth
                    value={this.props.username}
                    onChange={this.onUsernameChange}
                />
                <Button
                    variant="contained"
                    color="primary"
                    margin="normal"
                    fullWidth
                    onClick={this.handleSubmit}
                >
                    Log in
                </Button>
                <br/>
                <GoogleLogin
                    clientId="1017412956447-eifqard2r5ahtuhkt02la0bsshvtetbb.apps.googleusercontent.com"
                    buttonText="login"
                    onSuccess={this.responseGoogle}
                    onFailure={this.responseGoogle}
                />
                <br/>
                <br/>
                <div>
                    <Link to="/forgotPassword">forgot password?</Link>
                </div>
            </Container>
        )
    }
}

const mapStateToProps = state => {
    return {
        username: state.login.username,
        password: state.login.password,
    }
};

const mapDispatchToProps = {
    setUsernameText: setUsernameText,
    setPasswordText: setPasswordText
};

export default connect(mapStateToProps, mapDispatchToProps)(Login);