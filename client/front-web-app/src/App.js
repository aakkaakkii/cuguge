import React from 'react';
import './App.css';
import {createStore, applyMiddleware} from "redux";
import {Provider} from "react-redux";
import rootReducer from './store/reducers'
import Login from "./components/security/Login";
import Registration from "./components/security/Registration";
import thunk from "redux-thunk";
import {
    AppBar,
    Toolbar,
    Typography,
} from "@material-ui/core";
import {BrowserRouter, Link, Route, Switch, useHistory} from "react-router-dom";
import Home from "./components/Home";
import ForgotPassword from "./components/security/ForgotPassword";


const store = createStore(rootReducer, applyMiddleware(thunk));

function App() {
    return (
        <Provider store={store}>
            <BrowserRouter>
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
                    </Toolbar>
                </AppBar>

                <div>
                    <Switch>
                        <Route exact path='/' component={Home}/>
                        <Route exact path='/login' component={Login}/>
                        <Route exact path='/registration' component={Registration}/>
                        <Route exact path='/forgotPassword' component={ForgotPassword}/>
                    </Switch>
                </div>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
