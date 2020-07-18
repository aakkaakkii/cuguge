import React from "react";
import {connect} from "react-redux";
import {
    register,
    setMailText,
    setPasswordText,
    setRepeatPasswordText,
    setUsernameText
} from "../../store/registration/actions";
import {Button, Container, TextField} from "@material-ui/core";


class Registration extends React.Component {
    onUsernameChange = (event) => {
        this.props.setUsernameText(event.target.value);
    }

    onPasswordChange = (event) => {
        this.props.setPasswordText(event.target.value);
    }

    onRepeatPasswordChange = (event) => {
        this.props.setRepeatPasswordText(event.target.value);
    }

    onMailChange = (event) => {
        this.props.setMailText(event.target.value);
    }

    handleSubmit = () => {
        let user = {
            username: this.props.username,
            password: this.props.password,
            repeatPassword: this.props.repeatPassword,
            mail: this.props.mail,
        }

        this.props.registerUser(user);
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
                    label="Enter Password"
                    name='password'
                    margin="normal"
                    fullWidth
                    value={this.props.password}
                    onChange={this.onPasswordChange}
                />
                <TextField
                    type='password'
                    variant="outlined"
                    label="Repeat Password"
                    name='password'
                    margin="normal"
                    fullWidth
                    value={this.props.repeatPassword}
                    onChange={this.onRepeatPasswordChange}
                />
                <TextField
                    type='text'
                    variant="outlined"
                    label="Enter Mail"
                    name='mail'
                    margin="normal"
                    fullWidth
                    value={this.props.mail}
                    onChange={this.onMailChange}
                />
                <Button
                    variant="contained"
                    color="primary"
                    margin="normal"
                    fullWidth
                    onClick={this.handleSubmit}
                >
                    Register
                </Button>
            </Container>
        )
    }
}

const mapStateToProps = state => {
    return {
        username: state.registration.username,
        password: state.registration.password,
        repeatPassword: state.registration.repeatPassword,
        mail: state.registration.mail,
        user: state.registration.user,
        error: state.registration.error,
    }
};

const mapDispatchToProps = {
    setUsernameText: setUsernameText,
    setPasswordText: setPasswordText,
    setRepeatPasswordText: setRepeatPasswordText,
    setMailText: setMailText,
    registerUser: register,
};

export default connect(mapStateToProps, mapDispatchToProps)(Registration);
