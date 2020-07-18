import {
    LOAD_ROLES_SUCCESS,
    LOAD_USERS_ERROR,
    LOAD_USERS_PROCESSING,
    LOAD_USERS_SUCCESS, SAVE_USER_SUCCESS, USER_CHANGE,
} from "./actions";
import {DATA_STATUS_ERROR, DATA_STATUS_PROCESSING, DATA_STATUS_SUCCESS} from "../actions";

const defaultState = {
    users: [],
    roles: [],
    userStatus: null,
    user: {
        id: '',
        username: '',
        password: '',
        mail: '',
        active: false,
        img: '',
        roles: []
    }
}

export const userManagementReducer = (state = defaultState, action) => {
    switch (action.type) {
        case LOAD_USERS_PROCESSING:
            return {
                ...state,
                userStatus: DATA_STATUS_PROCESSING
            }
        case LOAD_USERS_SUCCESS:
            return {
                ...state,
                users: action.payload,
                userStatus: DATA_STATUS_SUCCESS
            }
        case LOAD_USERS_ERROR:
            return {
                ...state,
                userStatus: DATA_STATUS_ERROR
            }
        case SAVE_USER_SUCCESS:
            return {
                ...state,
                users: [...state.users, action.payload],
                userStatus: DATA_STATUS_SUCCESS
            }
        case USER_CHANGE:
            return {
                ...state,
                user: {...action.payload}
            }
        case LOAD_ROLES_SUCCESS:
            return {
                ...state,
                roles: action.payload
            }
        default:
            return state;
    }
}
