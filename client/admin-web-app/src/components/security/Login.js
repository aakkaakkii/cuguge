import React from "react";
import {connect} from "react-redux";
import {login, setPasswordText, setUsernameText} from "../../store/security/login/actions";
import {Button, Container, TextField} from "@material-ui/core";
import {Link} from "react-router-dom";


class Login extends React.Component {
    onUsernameChange = (event) => {
        this.props.setUsernameText(event.target.value);
    }

    onPasswordChange = (event) => {
        this.props.setPasswordText(event.target.value);
    }

    handleSubmit = () => {
        let user = {
            username: this.props.username,
            password: this.props.password,
        }

        this.props.login(user);
    }

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
                    label="Enter password"
                    name='password'
                    margin="normal"
                    fullWidth
                    value={this.props.password}
                    onChange={this.onPasswordChange}
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
                <br/>
                <br/>
            </Container>
        )
    }
}

const mapStateToProps = state => {
    return {
        username: state.security.login.username,
        password: state.security.login.password,
    }
};

const mapDispatchToProps = {
    setUsernameText: setUsernameText,
    setPasswordText: setPasswordText,
    login: login
};

export default connect(mapStateToProps, mapDispatchToProps)(Login);
