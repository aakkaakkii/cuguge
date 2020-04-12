package ge.cugu.user;

import ge.cugu.domain.user.User;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream()
                .map(UserPersistenceAdapter::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).map(UserPersistenceAdapter::toDomain).orElse(null);

    }

    @Override
    public User findByMail(String mail) {
        return toDomain(userRepository.findByMail(mail));
    }

    @Override
    public User findByMailOrUsernameAndType(String mailOrUsername, User.Type type) {
        return toDomain(userRepository.findByMailOrUsernameOrType(mailOrUsername, type));
    }

    @Override
    public User findByUsername(String username) {
        return toDomain(userRepository.findByUsername(username));
    }

    @Override
    public User add(User user) {
        return toDomain(userRepository.save(fromDomain(user)));
    }

    @Override
    public User update(User user) {
        return toDomain(userRepository.save(fromDomain(user)));
    }

    public static UserEntity fromDomain(User domain) {
        return domain == null ? null : UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .username(domain.getUsername())
                .password(domain.getPassword())
                .mail(domain.getMail())
                .img(domain.getImg())
                .active(domain.isActive())
                .roles(domain.getRoles())
                .type(domain.getType())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return entity == null? null : User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .mail(entity.getMail())
                .img(entity.getImg())
                .active(entity.isActive())
                .roles(entity.getRoles())
                .type(entity.getType())
                .build();
    }
}
