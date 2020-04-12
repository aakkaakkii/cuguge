package ge.cugu.service.user;

import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.in.user.ListUsersUseCase;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListUsersService implements ListUsersUseCase {
    private final UserPort userPort;

    @Override
    public List<UserResponseModel> loadUsers() {
        return userPort.findAll().stream()
                .map(UserResponseModel::fromDomain)
                .collect(Collectors.toList());
    }
}
