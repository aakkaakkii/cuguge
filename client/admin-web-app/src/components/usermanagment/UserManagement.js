import React from "react";
import {connect} from "react-redux";
import {Button, Container, TextField} from "@material-ui/core";
import {
    loadUsers,
    addUser,
    setUserChange,
    loadRoles
} from "../../store/usermanagment/actions";
import Grid from "@material-ui/core/Grid";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import Switch from "@material-ui/core/Switch";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import MenuItem from "@material-ui/core/MenuItem";


class UserManagement extends React.Component {
    componentDidMount() {
        this.props.loadUsers()
        this.props.loadRoles()
    }

    onFieldChange = (e) => {
        let user = this.props.user;
        user[e.target.name] = e.target.value

        this.props.setUserChange(user)
    }

    onSelectChange = (e) => {
        let user = this.props.user;
        user[e.target.name] = e.target.checked

        this.props.setUserChange(user)
    }

    handleSubmit = () => {
        this.props.addUser(this.props.user);
    }

    onSelectUser = (user) => {
        user.password = ''
        this.props.setUserChange(user)
    }

    render() {
        return (
            <Container maxWidth="md">
                <Grid container>
                    <Grid item xs={6} align="center">
                        <div>{this.props.userStatus}</div>
                        {this.props.users.map(d =>
                            <div key={d.id}
                                 onClick={() => this.onSelectUser(d)}
                            > {d.id} - {d.username} - {d.mail}</div>
                        )}
                    </Grid>
                    <Grid item xs={6} align="center">
                        <FormControl>
                            <TextField type='text'
                                       variant="outlined"
                                       label="Username"
                                       name='username'
                                       onChange={this.onFieldChange}
                                       value={this.props.user.username}
                            />
                            <TextField type='password'
                                       variant="outlined"
                                       label="Password"
                                       name='password'
                                       onChange={this.onFieldChange}
                                       value={this.props.user.password}
                            />
                            <TextField type='text'
                                       variant="outlined"
                                       label="Mail"
                                       name='mail'
                                       onChange={this.onFieldChange}
                                       value={this.props.user.mail}
                            />
                            <Select
                                multiple
                                variant="outlined"
                                name='roles'
                                onChange={this.onFieldChange}
                                value={this.props.user.roles}
                            >
                                {this.props.roles.map(role => <MenuItem key={role} value={role}>{role}</MenuItem>)}
                            </Select>
                            <FormControlLabel
                                control={<Switch name='active'
                                                 checked={this.props.user.active || false}
                                                 onChange={this.onSelectChange} />}
                                label="Active"
                            />
                            <Button
                                variant="contained"
                                color="primary"
                                margin="normal"
                                fullWidth
                                onClick={this.handleSubmit}
                            >
                                Add
                            </Button>
                        </FormControl>
                    </Grid>
                </Grid>
            </Container>
        )
    }
}

const mapStateToProps = state => {
    return {
        users: state.userManagement.users,
        userStatus: state.userManagement.userStatus,
        user: state.userManagement.user,
        roles: state.userManagement.roles,
    }
};

const mapDispatchToProps = {
    loadUsers: loadUsers,
    addUser: addUser,
    setUserChange: setUserChange,
    loadRoles: loadRoles,
};

export default connect(mapStateToProps, mapDispatchToProps)(UserManagement);
