import React from 'react';
import './App.css';
import {applyMiddleware, createStore} from "redux";
import {Provider} from "react-redux";
import rootReducer from './store/reducers'
import Login from "./components/security/Login";
import thunk from "redux-thunk";
import {AppBar, Toolbar, Typography,} from "@material-ui/core";
import {BrowserRouter, Link, Route, Switch} from "react-router-dom";
import UserManagement from "./components/usermanagment/UserManagement";


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
                <Link to="/userManagement">userManagement</Link>
              </Typography>
              <Typography>
                <Link to="/login">login</Link>
              </Typography>
            </Toolbar>
          </AppBar>

          <div>
            <Switch>
              <Route exact path='/login' component={Login}/>
              <Route exact path='/userManagement' component={UserManagement}/>
            </Switch>
          </div>
        </BrowserRouter>
      </Provider>
  );
}

export default App;
