// export const APP_URL = window.location.protocol+"//"+window.location.hostname+":"+window.location.port
import {getFullJwt} from "./jwtUtil";

export const APP_URL = 'http://localhost:8080'
export const APP_API_URL = APP_URL + '/api'

export const parseError = error => {
    console.error(error);

    if (error.response
        && error.response.data
        && error.response.data.message) {
        return error.response.data.message;
    }
    //TODO change error message
    return 'some';
}

export const addAuthorizationToHeaders = (header) => {
    if (header) {
        return {...header, Authorization: getFullJwt()}
    }
    return {Authorization: getFullJwt()}
}