package ge.cugu.service.user;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.domain.user.User;
import ge.cugu.port.in.user.RegisterUserUseCase;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;
import ge.cugu.port.mapper.UserMapper;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.requestmodel.user.RegisterUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.out.authentication.AuthUtilPort;
import ge.cugu.port.out.mail.MailPort;
import ge.cugu.port.out.user.ActivationCodePort;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegisterUserService implements RegisterUserUseCase {
    private final UserPort userPort;
    private final ActivationCodePort activationCodePort;
    private final MailPort mailPort;
    private final AuthUtilPort authUtilPort;
    private final UserMapper userMapper;

    @Override
    public UserResponseModel register(RegisterUserRequestModel user) throws PasswordDidntMatchException, UserAlreadyExists {

        if (!user.getPassword().equals(user.getRepeatPassword())) {
            throw new PasswordDidntMatchException();
        }
        if(userPort.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExists(user.getUsername());
        }
        if(userPort.findByMail(user.getMail()) != null){
            throw new UserAlreadyExists(user.getUsername());
        }

        User newUser = User.builder()
                .username(user.getUsername())
                .mail(user.getMail())
                .password(authUtilPort.encodePassword(user.getPassword()))
                .build();

        newUser.setActive(false);
        newUser.setType(User.Type.DEFAULT);
        newUser.setRoles(Collections.singleton(User.Role.USER));

        User addedUser = userPort.add(newUser);

        sendActivationCode(addedUser);

        return userMapper.toUserResponse(addedUser);
    }

    @Override
    public void activate(String code) {
        ActivationCode activationCode = activationCodePort.findByCode(code);
        if(activationCode != null && activationCode.getUser() != null) {
            User user = activationCode.getUser();
            user.activateUser();
            userPort.update(user);
            activationCodePort.delete(activationCode.getId());
        }
    }

    private void sendActivationCode(User user) {

        ActivationCode activationCode = activationCodePort.add(ActivationCode.builder()
                .activationCode(UUID.randomUUID().toString())
                .user(user)
                .build());

        String message = String.format(
                "Hello %s!\n" +
                        "Welcome to CUGUGE. Please visit next link: http://localhost:8080/api/registration/activation/%s",
                user.getUsername(),
                activationCode.getActivationCode()
        );

        mailPort.send(user.getMail(), "Activation Code", message);
    }
}
