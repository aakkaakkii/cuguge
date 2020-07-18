import {parseError} from "../../../util/apiUtil";
import {getUsername, getUserRole, setJwt} from "../../../util/jwtUtil";
import {loginUser} from "../../../api/security/login";

export const LOGIN_CHANGE_USERNAME_TEXT = 'LOGIN_CHANGE_USERNAME_TEXT';
export const LOGIN_CHANGE_PASSWORD_TEXT = 'LOGIN_CHANGE_PASSWORD_TEXT';

export const LOGIN_PROCESSING = 'LOGIN_PROCESSING';
export const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
export const LOGIN_ERROR = 'LOGIN_ERROR';

export const setUsernameText = username => ({
    type: LOGIN_CHANGE_USERNAME_TEXT,
    payload: username
});

export const setPasswordText = password => ({
    type: LOGIN_CHANGE_PASSWORD_TEXT,
    payload: password
});

export const loginError = error => ({
    type: LOGIN_ERROR,
    payload: parseError(error)
});

export const login = (user) => async dispatch => {
    try {
        dispatch({type: LOGIN_PROCESSING})
        let response = await loginUser(user);
        let token = response.data;

        setJwt(token);
        console.log(getUsername())
        console.log(getUserRole())



        // localStorage.setItem(APP_USER, data.username)
        // localStorage.setItem(APP_JWT, data.token)

        // dispatch({type: 'LOGIN_SUCCESS', payload: response.data})
    } catch (error) {
        dispatch(loginError(error))
    }
}
