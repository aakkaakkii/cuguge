export const LOGIN_CHANGE_USERNAME_TEXT = 'LOGIN_CHANGE_USERNAME_TEXT';
export const LOGIN_CHANGE_PASSWORD_TEXT = 'LOGIN_CHANGE_PASSWORD_TEXT';

export const setUsernameText = username => ({
   type: LOGIN_CHANGE_USERNAME_TEXT,
   payload: username
});

export const setPasswordText = password => ({
    type: LOGIN_CHANGE_PASSWORD_TEXT,
    payload: password
});
