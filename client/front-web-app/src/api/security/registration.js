import axios from "axios";
import {APP_API_URL} from "../../util/apiUtil";

export const registerUser = user => {
    return axios.post(APP_API_URL+'/registration', user);
}
