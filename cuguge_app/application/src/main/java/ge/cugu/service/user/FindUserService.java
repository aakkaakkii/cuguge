package ge.cugu.service.user;

import ge.cugu.domain.user.User;
import ge.cugu.port.in.user.FindUserUseCase;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserService implements FindUserUseCase {
    private final UserPort userPort;

    @Override
    public User findUserByUsername(String username) {
        return userPort.findByUsername(username);
    }

    @Override
    public User findById(Long id)  {
        return userPort.findById(id);
    }
}
