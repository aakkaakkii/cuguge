import {combineReducers} from "redux";
import {loginReducer} from "./login/reducers";
import {registrationReducer} from "./registration/reducers";
import {createPost} from "./post/reducers";

export default combineReducers({
    login: loginReducer,
    registration: registrationReducer,
    createPost: createPost
});
