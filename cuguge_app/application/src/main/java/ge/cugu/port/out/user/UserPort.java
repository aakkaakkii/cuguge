package ge.cugu.port.out.user;

import ge.cugu.domain.user.User;

import java.util.List;

public interface UserPort {
    List<User> findAll(int start, int limit);
    User findById(Long id);
    User findByMail(String mail);
    User findByMailOrUsernameAndType(String mailOrUsername, User.Type type);
    User findByUsername(String username);
    User add(User user);
    User update(User user);

}
