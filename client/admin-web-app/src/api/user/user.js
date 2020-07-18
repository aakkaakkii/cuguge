import axios from "axios";
import {addAuthorizationToHeaders, APP_API_URL} from "../../util/apiUtil";

export const addUser = (user) => {
    return axios.post(APP_API_URL + '/user', user, {headers: addAuthorizationToHeaders({})});
}

export const updateUser = (user) => {
    return axios.put(APP_API_URL + `/user/${user.id}`, user, {headers: addAuthorizationToHeaders({})});
}


export const loadUsers = () => {
    return axios.get(APP_API_URL + '/user', {headers: addAuthorizationToHeaders({})});
}

export const loadRoles = () => {
    return axios.get(APP_API_URL + '/user/roles', {headers: addAuthorizationToHeaders({})});
}

export const userApi = {
    addUser: addUser,
    updateUser: updateUser,
    loadUsers: loadUsers,
    loadRoles: loadRoles,
}
