import {
    REGISTRATION_CHANGE_MAIL_TEXT,
    REGISTRATION_CHANGE_PASSWORD_TEXT,
    REGISTRATION_CHANGE_REPEAT_PASSWORD_TEXT,
    REGISTRATION_CHANGE_USERNAME_TEXT, REGISTRATION_ERROR, REGISTRATION_REGISTERED, REGISTRATION_REGISTERING
} from "./actions";
import {DATA_STATUS_ERROR, DATA_STATUS_SUCCESS, DATA_STATUS_PROCESSING} from "../actions";

const defaultState = {
    username : '',
    password: '',
    repeatPassword: '',
    mail: ''

}

export const registrationReducer = (state = defaultState, action) => {
    switch (action.type) {
        case REGISTRATION_CHANGE_USERNAME_TEXT:
            return {
                ...state,
                username: action.payload
            }
        case REGISTRATION_CHANGE_PASSWORD_TEXT:
            return {
                ...state,
                password: action.payload
            }
        case REGISTRATION_CHANGE_REPEAT_PASSWORD_TEXT:
            return {
                ...state,
                repeatPassword: action.payload
            }
        case REGISTRATION_CHANGE_MAIL_TEXT:
            return {
                ...state,
                mail: action.payload
            }
        case REGISTRATION_REGISTERING:
            return {
                ...state,
                dataStatus: DATA_STATUS_PROCESSING
            }
        case REGISTRATION_REGISTERED:
            return {
                ...state,
                user: action.payload,
                dataStatus: DATA_STATUS_SUCCESS
            }
        case REGISTRATION_ERROR:
            return {
                ...state,
                error: action.payload,
                dataStatus: DATA_STATUS_ERROR
            }
        default:
            return state;
    }
}
