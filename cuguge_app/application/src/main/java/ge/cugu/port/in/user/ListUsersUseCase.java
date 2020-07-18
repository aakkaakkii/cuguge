package ge.cugu.port.in.user;

import ge.cugu.domain.user.User;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;

import java.util.List;

public interface ListUsersUseCase {
    List<UserResponseModel> loadUsers();
    UserResponseModel findUserByUsername(String username);
    List<User.Role> loadRoles();
}
