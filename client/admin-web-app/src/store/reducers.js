import {combineReducers} from "redux";
import securityReducer from "./security/reducers";
import {userManagementReducer} from "./usermanagment/reducers";

export default combineReducers({
    security: securityReducer,
    userManagement: userManagementReducer,
});
