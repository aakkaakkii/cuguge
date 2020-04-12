package ge.cugu.port.in.user;

import ge.cugu.port.model.responsemodel.user.UserResponseModel;

import java.util.List;

public interface ListUsersUseCase {
    List<UserResponseModel> loadUsers();
}
