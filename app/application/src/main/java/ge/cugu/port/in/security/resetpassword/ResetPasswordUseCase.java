package ge.cugu.port.in.security.resetpassword;

import ge.cugu.port.in.security.resetpassword.exception.CurrentPasswordIsIncorrectException;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserNotFoundException;
import ge.cugu.port.model.requestmodel.resetpassword.ForgotPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetForgottenPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetPasswordRequestModel;

public interface ResetPasswordUseCase {
    void resetPassword(String username, ResetPasswordRequestModel model) throws PasswordDidntMatchException, UserNotFoundException, CurrentPasswordIsIncorrectException;
    void forgotPassword(ForgotPasswordRequestModel model);
    void resetForgottenPassword(String code, ResetForgottenPasswordRequestModel model) throws PasswordDidntMatchException;
}
