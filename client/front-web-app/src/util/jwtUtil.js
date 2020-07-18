import jwt from 'jwt-decode'

export const APP_JWT = 'APP_JWT'
export const APP_USER = 'APP_USER'
export const APP_USER_ROLE = 'APP_USER_ROLE'
export const APP_USER_ID = 'APP_USER_ID'

export const setJwt = (token) => {
    let parsedToken = jwt(token);
    localStorage.setItem(APP_JWT, token);
    localStorage.setItem(APP_USER, parsedToken.sub);
    localStorage.setItem(APP_USER_ROLE, JSON.stringify(parsedToken.roles));
}

export const getJwt = () => {
    return localStorage.getItem(APP_JWT);
}

export const getFullJwt = () => {
    return 'Bearer_' + getJwt();
}

export const getUsername = () => {
    return localStorage.getItem(APP_USER)
}

export const getUserRole = () => {
    return JSON.parse(localStorage.getItem(APP_USER_ROLE));
}

export const getUsernameId = () => {
    return localStorage.getItem(APP_USER_ID)
}

export const clearUserDataFromLocalStorage = () => {
    localStorage.removeItem(APP_JWT);
    localStorage.removeItem(APP_USER);
    localStorage.removeItem(APP_USER_ID);
    localStorage.removeItem(APP_USER_ROLE);
}

