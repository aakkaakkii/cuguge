export const APP_JWT = 'app_jwt'
export const APP_USER = 'app_user'
export const APP_USER_ID = 'app_user_id'

export const getJwt = () => {
    return localStorage.getItem(APP_JWT);
}

export const getFullJwt = () => {
    return 'Bearer_' + getJwt();
}

export const getUsername = () => {
    return localStorage.getItem(APP_USER)
}

export const getUsernameId = () => {
    return localStorage.getItem(APP_USER_ID)
}

export const clearUserDataFromLocalStorage = () => {
    localStorage.removeItem(APP_JWT);
    localStorage.removeItem(APP_USER);
    localStorage.removeItem(APP_USER_ID);
}

