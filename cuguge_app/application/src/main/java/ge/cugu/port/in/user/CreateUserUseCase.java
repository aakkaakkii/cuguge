package ge.cugu.port.in.user;

import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;

public interface CreateUserUseCase {
    UserResponseModel create(CreateUserRequestModel user)
            throws UserAlreadyExists;

    UserResponseModel updateUser(CreateUserRequestModel user)
            throws UserAlreadyExists;
}
