import axios from "axios";
import {APP_API_URL} from "../../util/apiUtil";

export const googleAuth = token => {
    return axios.post(APP_API_URL+'/auth/google', {token: token});
}

export const loginUser = user => {
    return axios.post(APP_API_URL+'/auth/login', user);
}
