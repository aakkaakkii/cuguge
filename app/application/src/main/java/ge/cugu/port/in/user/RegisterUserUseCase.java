package ge.cugu.port.in.user;

import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.PasswordIsEmptyException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;

public interface RegisterUserUseCase {
    UserResponseModel register(CreateUserRequestModel user)
            throws PasswordDidntMatchException, UserAlreadyExists;
    void activate(String code);
}
