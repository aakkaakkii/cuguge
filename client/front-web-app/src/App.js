import React from 'react';
import './App.css';
import {applyMiddleware, createStore} from "redux";
import {Provider} from "react-redux";
import rootReducer from './store/reducers'
import Login from "./components/login/Login";
import Registration from "./components/registration/Registration";
import thunk from "redux-thunk";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Home from "./components/home/Home";
import ForgotPassword from "./components/forgotpassword/ForgotPassword";
import CreatePost from "./components/createpost/CreatePost";
import Post from "./components/post/Post";
import Header from "./components/ui/header/Header";


const store = createStore(rootReducer, applyMiddleware(thunk));

function App() {
    return (
        <Provider store={store} >
            <BrowserRouter>
                <Header/>

                <div>
                    <Switch>
                        <Route exact path='/' component={Home}/>
                        <Route exact path='/createPost' component={CreatePost}/>
                        <Route exact path='/login' component={Login}/>
                        <Route exact path='/registration' component={Registration}/>
                        <Route exact path='/forgotPassword' component={ForgotPassword}/>
                        <Route exact path='/post/:id' component={Post}/>
                    </Switch>
                </div>
            </BrowserRouter>
        </Provider>
    );
}

export default App;
