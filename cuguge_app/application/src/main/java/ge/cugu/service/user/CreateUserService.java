package ge.cugu.service.user;

import ge.cugu.domain.user.User;
import ge.cugu.port.in.user.CreateUserUseCase;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;
import ge.cugu.port.mapper.UserMapper;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.out.authentication.AuthUtilPort;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UserPort userPort;
    private final AuthUtilPort authUtilPort;
    private final UserMapper userMapper;

    @Override
    public UserResponseModel create(CreateUserRequestModel user) throws UserAlreadyExists {

        if(userPort.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExists(user.getUsername());
        }

        User newUser = User.builder()
                .username(user.getUsername())
                .mail(user.getMail())
                .password(authUtilPort.encodePassword(user.getPassword()))
                .roles(user.getRoles())
                .active(user.isActive())
                .build();

        newUser.setType(User.Type.DEFAULT);

        return userMapper.toUserResponse(userPort.add(newUser));
    }

    @Override
    public UserResponseModel updateUser(CreateUserRequestModel user) throws  UserAlreadyExists {

        if(userPort.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExists(user.getUsername());
        }

        User newUser = User.builder()
                .username(user.getUsername())
                .mail(user.getMail())
                .password(authUtilPort.encodePassword(user.getPassword()))
                .roles(user.getRoles())
                .active(user.isActive())
                .build();

        newUser.setType(User.Type.DEFAULT);

        return userMapper.toUserResponse(userPort.add(newUser));
    }
}
