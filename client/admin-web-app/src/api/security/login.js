import axios from "axios";
import {APP_API_URL} from "../../util/apiUtil";

export const loginUser = user => {
    return axios.post(APP_API_URL+'/auth/login', user);
}
