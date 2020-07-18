package ge.cugu.user;

import ge.cugu.domain.user.User;
import ge.cugu.image.ImagePersistenceAdapter;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public List<User> findAll(int start, int limit) {
        return userRepository.findAll(PageRequest.of(start / limit, limit)).stream()
                .map(userEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userEntityMapper.toDomain(userRepository.getOne(id));
    }

    @Override
    public User findByMail(String mail) {
        return userEntityMapper.toDomain(userRepository.findByMail(mail));
    }

    @Override
    public User findByMailOrUsernameAndType(String mailOrUsername, User.Type type) {
        return userEntityMapper.toDomain(userRepository.findByMailOrUsernameOrType(mailOrUsername, type));
    }

    @Override
    public User findByUsername(String username) {
        return userEntityMapper.toDomain(userRepository.findByUsername(username));
    }

    @Override
    public User add(User user) {
        return userEntityMapper.toDomain(userRepository.save(userEntityMapper.toEntity(user)));
    }

    @Override
    public User update(User user) {
        return userEntityMapper.toDomain(userRepository.save(userEntityMapper.toEntity(user)));
    }

}
