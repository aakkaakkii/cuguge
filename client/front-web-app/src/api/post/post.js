import axios from "axios";
import {addAuthorizationToHeaders, APP_API_URL} from "../../util/apiUtil";


export const createPost = post => {
    return axios.post(APP_API_URL + '/post', post,{
        headers: addAuthorizationToHeaders({
            headers: {
                "Content-Type": "multipart/form-data"
            }
        })
    });
}

export const loadPosts = () => {
    return axios.get(`${APP_API_URL}/post`,{
        headers: addAuthorizationToHeaders({})
    });
}

export const getPost = (id) => {
    return axios.get(`${APP_API_URL}/post/${id}`,{
        headers: addAuthorizationToHeaders({})
    });
}
