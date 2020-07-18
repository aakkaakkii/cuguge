import React from "react";
import {connect} from "react-redux";
import {setPasswordText, setUsernameText} from "../../store/login/actions";
import {Button, Container, TextField} from "@material-ui/core";


class ForgotPassword extends React.Component {
    onUsernameChange = (event) => {
        this.props.setUsernameText(event.target.value);
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
                <Button
                    variant="contained"
                    color="primary"
                    margin="normal"
                    fullWidth
                    onClick={this.handleSubmit}
                >
                    Reset password
                </Button>
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

export default connect(mapStateToProps, mapDispatchToProps)(ForgotPassword);
