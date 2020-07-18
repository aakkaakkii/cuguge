import {
    ADD_CREATE_POST_DESCRIPTION_TEXT,
    ADD_CREATE_POST_IMAGE,
    ADD_CREATE_POST_TITLE_TEXT,
    CLEAR_CREATE_POST_IMAGES,
    GET_POST_PROGRESS,
    GET_POST_SUCCESS,
    LOAD_POSTS_FAILURE,
    LOAD_POSTS_SUCCESS,
    REMOVE_CREATE_POST_IMAGE
} from "./actions";

const defaultState = {
    createPostImages: [],
    postDescription: '',
    postTitle: '',
    postList: [],
    post: null
}

export const createPost = (state = defaultState, action) => {
    switch (action.type) {
        case ADD_CREATE_POST_IMAGE:
            return {
                ...state,
                createPostImages: [...state.createPostImages, action.payload]
            }
        case ADD_CREATE_POST_TITLE_TEXT:
            return {
                ...state,
                postTitle: action.payload
            }
        case CLEAR_CREATE_POST_IMAGES:
            return {
                ...state,
                createPostImages: []
            }
        case ADD_CREATE_POST_DESCRIPTION_TEXT:
            return {
                ...state,
                postDescription: action.payload
            }
        case REMOVE_CREATE_POST_IMAGE:
            return {
                ...state,
                createPostImages: [...state.createPostImages.filter((d)=> d.path !== action.payload)]
            }
        case LOAD_POSTS_SUCCESS:
            return {
                ...state,
                postList: action.payload
            }
        case GET_POST_SUCCESS:
            return {
                ...state,
                post: action.payload
            }
        case GET_POST_PROGRESS:
            return {
                ...state,
                post: null
            }
        default:
            return state
    }
}
