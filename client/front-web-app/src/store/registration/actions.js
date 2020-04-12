import {registerUser} from "../../api/security/registration";
import {parseError} from "../../util/apiUtil";

export const REGISTRATION_CHANGE_USERNAME_TEXT = 'REGISTRATION_CHANGE_USERNAME_TEXT';
export const REGISTRATION_CHANGE_PASSWORD_TEXT = 'REGISTRATION_CHANGE_PASSWORD_TEXT';
export const REGISTRATION_CHANGE_REPEAT_PASSWORD_TEXT = 'REGISTRATION_CHANGE_REPEAT_PASSWORD_TEXT';
export const REGISTRATION_CHANGE_MAIL_TEXT = 'REGISTRATION_CHANGE_MAIL_TEXT';

export const REGISTRATION_REGISTERING = 'REGISTRATION_REGISTERING';
export const REGISTRATION_REGISTERED = 'REGISTRATION_REGISTERED';
export const REGISTRATION_ERROR = 'REGISTRATION_ERROR';



export const setUsernameText = username => ({
    type: REGISTRATION_CHANGE_USERNAME_TEXT,
    payload: username
});

export const setPasswordText = password => ({
    type: REGISTRATION_CHANGE_PASSWORD_TEXT,
    payload: password
});

export const setRepeatPasswordText = repeatPassword => ({
    type: REGISTRATION_CHANGE_REPEAT_PASSWORD_TEXT,
    payload: repeatPassword
});

export const setMailText = mail => ({
    type: REGISTRATION_CHANGE_MAIL_TEXT,
    payload: mail
});

export const register = (user) => async dispatch => {
    try {
        dispatch({type: 'REGISTRATION_REGISTERING'})
        let response = await registerUser(user);
        console.error(response)
        dispatch({type: 'REGISTRATION_REGISTERED', payload: response.data})
    } catch (error) {
        dispatch({type: 'REGISTRATION_ERROR', payload: parseError(error)})
    }
}
