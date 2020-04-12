import axios from "axios";
import {addAuthorizationToHeaders, APP_API_URL} from "../../util/apiUtil";

export const loadUsers = () => {
    return axios.get(APP_API_URL+'/user', {headers: addAuthorizationToHeaders({})});
}
