import {parseError} from "../../util/apiUtil";
import {userApi} from "../../api/user/user";

export const LOAD_USERS_PROCESSING = 'LOAD_USERS_PROCESSING';
export const LOAD_USERS_SUCCESS = 'LOAD_USERS_SUCCESS';
export const LOAD_USERS_ERROR = 'LOAD_USERS_ERROR';

export const LOAD_ROLES_PROCESSING = 'LOAD_ROLES_PROCESSING';
export const LOAD_ROLES_SUCCESS = 'LOAD_ROLES_SUCCESS';
export const LOAD_ROLES_ERROR = 'LOAD_ROLES_ERROR';

export const SAVE_USER_PROCESSING = 'SAVE_USER_PROCESSING';
export const SAVE_USER_SUCCESS = 'SAVE_USER_SUCCESS';
export const SAVE_USER_ERROR = 'SAVE_USER_ERROR';

export const USER_CHANGE= 'USER_CHANGE';

//load user
export const loadUsersProgress = () => ({
    type: LOAD_USERS_PROCESSING,
})

export const loadUsersSuccess = (users) => ({
    type: LOAD_USERS_SUCCESS,
    payload: users
})

export const loadUsersError = error => ({
    type: LOAD_USERS_ERROR,
    payload: parseError(error)
});

export const loadRolesSuccess = roles => ({
    type: LOAD_ROLES_SUCCESS,
    payload: roles
})

//save user
/*export const loadUsersProgress = () => ({
    type: SAVE_USER_PROCESSING,
})*/

export const addUsersSuccess = (users) => ({
    type: SAVE_USER_SUCCESS,
    payload: users
})

/*export const loadUsersError = error => ({
    type: LOAD_USERS_ERROR,
    payload: parseError(error)
});*/

export const setUserChange = user => ({
    type: USER_CHANGE,
    payload: user
})


export const loadUsers = () => async dispatch => {
    try {

        dispatch(loadUsersProgress())
        let response = await userApi.loadUsers();
        let users = response.data
        dispatch(loadUsersSuccess(users))
    } catch (error) {
        dispatch(loadUsersError(error))
    }
}

export const addUser = (user) => async dispatch => {
    try {
        dispatch(loadUsersProgress())
        let savedUser = await userApi.addUser(user);

        dispatch(addUsersSuccess(savedUser));
        // dispatch(setUserChange(savedUser));
    } catch (error) {
        dispatch(loadUsersError(error));
    }
}

export const loadRoles = () => async dispatch => {
    try {
        dispatch(loadUsersProgress())

        let response = await userApi.loadRoles();
        let roles = response.data

        dispatch(loadRolesSuccess(roles))


    } catch (error) {
        dispatch(loadUsersError(error));
    }
}
