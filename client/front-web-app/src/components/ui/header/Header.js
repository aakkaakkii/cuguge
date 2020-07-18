import React from "react";
import {AppBar, Toolbar, Typography} from "@material-ui/core";
import {Link} from "react-router-dom";

const Header = () => {
    return(
        <AppBar position="static">
            <Toolbar>
                <Typography>
                    <Link to="/">Home</Link>
                </Typography>
                <Typography>
                    <Link to="/registration">registration</Link>
                </Typography>
                <Typography>
                    <Link to="/login">login</Link>
                </Typography>
                <Typography>
                    <Link to="/createPost">create Post</Link>
                </Typography>
            </Toolbar>
        </AppBar>
    )
}

export default Header;
