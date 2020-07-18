package ge.cugu.service.user;

import ge.cugu.domain.user.User;
import ge.cugu.port.mapper.UserMapper;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.in.user.ListUsersUseCase;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListUsersService implements ListUsersUseCase {
    private final UserPort userPort;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseModel> loadUsers() {
        return userPort.findAll(0,20).stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseModel findUserByUsername(String username) {
        return userMapper.toUserResponse(userPort.findByUsername(username));
    }

    @Override
    public List<User.Role> loadRoles() {
        return Arrays.asList(User.Role.values());
    }
}
