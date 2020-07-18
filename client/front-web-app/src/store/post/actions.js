import {createPost, getPost as getPostApi, loadPosts as loadPostsApi} from "../../api/post/post";

export const ADD_CREATE_POST_IMAGE = 'ADD_CREATE_POST_IMAGE'
export const REMOVE_CREATE_POST_IMAGE = 'REMOVE_CREATE_POST_IMAGE'
export const CLEAR_CREATE_POST_IMAGES = 'CLEAR_CREATE_POST_IMAGES'
export const ADD_CREATE_POST_TITLE_TEXT = 'ADD_CREATE_POST_TITLE_TEXT'
export const ADD_CREATE_POST_DESCRIPTION_TEXT = 'ADD_CREATE_POST_DESCRIPTION_TEXT'
export const GET_POST_SUCCESS = 'GET_POST_SUCCESS'
export const GET_POST_PROGRESS = 'GET_POST_PROGRESS'
export const GET_POST_FAILURE = 'GET_POST_FAILURE'
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS'
export const LOAD_POSTS_PROGRESS = 'LOAD_POSTS_PROGRESS'
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE'

export const addCreatePostImages = (file) => ({
    type: ADD_CREATE_POST_IMAGE,
    payload: file
})

export const removeCreatePostImages = (id) => ({
    type: REMOVE_CREATE_POST_IMAGE,
    payload: id
})

export const clearCreatePostImages = () =>({
    type: CLEAR_CREATE_POST_IMAGES
})

export const setPostTitleText = (title) => ({
    type: ADD_CREATE_POST_TITLE_TEXT,
    payload: title
})

export const setPostDescriptionText = (description) => ({
    type: ADD_CREATE_POST_DESCRIPTION_TEXT,
    payload: description
})

export const getPostProgressing = () => ({
    type: GET_POST_PROGRESS,
})

export const getPostSuccess = (post) => ({
    type: GET_POST_SUCCESS,
    payload: post
})

export const getPostFailure = (error) => ({
    type: GET_POST_FAILURE,
    payload: error
})

export const loadPostsProgressing = () => ({
    type: LOAD_POSTS_PROGRESS,
})

export const loadPostsSuccess = (post) => ({
    type: LOAD_POSTS_SUCCESS,
    payload: post
})

export const loadPostsFailure = (error) => ({
    type: LOAD_POSTS_FAILURE,
    payload: error
})

export const loadPosts = () => async dispatch => {
    try {
        dispatch(loadPostsProgressing())
        let response = await loadPostsApi();
        let posts = response.data.list;
        dispatch(loadPostsSuccess(posts))

    } catch (e) {
        dispatch(loadPostsFailure(e))
    }
}

export const getPost = (id) => async dispatch => {
    try {
        dispatch(getPostProgressing())
        let response = await getPostApi(id);
        let post = response.data;
        dispatch(getPostSuccess(post))

    } catch (e) {
        dispatch(getPostFailure(e))
    }
}

export const savePost = (post) => async dispatch =>{
    try{
        await createPost(post);
        dispatch(clearCreatePostImages())
        dispatch(setPostTitleText(""))
        dispatch(setPostDescriptionText(""))

    } catch (e) {
        console.log(e)
    }
}
