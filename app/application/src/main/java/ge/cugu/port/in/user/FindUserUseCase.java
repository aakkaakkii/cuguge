package ge.cugu.port.in.user;

import ge.cugu.domain.user.User;

public interface FindUserUseCase {
    User findUserByUsername(String username);
    User findById(Long id);
}
