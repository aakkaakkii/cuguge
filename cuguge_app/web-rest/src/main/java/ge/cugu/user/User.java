package ge.cugu.user;

import ge.cugu.port.in.user.CreateUserUseCase;
import ge.cugu.port.in.user.ListUsersUseCase;
import ge.cugu.port.in.user.RegisterUserUseCase;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class User {
    private final CreateUserUseCase createUserUseCase;
    private final ListUsersUseCase listUsersUseCase;

    @GetMapping
    public List<UserResponseModel> loadUsers(){
        return listUsersUseCase.loadUsers();
    }

    @GetMapping("/{username}")
    public UserResponseModel getUser(@PathVariable String username) {
        return listUsersUseCase.findUserByUsername(username);
    }

    @PostMapping
    public UserResponseModel addUser(@RequestBody CreateUserRequestModel user)
            throws PasswordDidntMatchException, UserAlreadyExists {
        return createUserUseCase.create(user);
    }

    @PutMapping("/{id}")
    public UserResponseModel updateUser(@PathVariable Long id, @RequestBody CreateUserRequestModel user)
            throws PasswordDidntMatchException, UserAlreadyExists {
        return createUserUseCase.updateUser(user);
    }

    @GetMapping("/roles")
    public List<ge.cugu.domain.user.User.Role> getRoles() {
        return listUsersUseCase.loadRoles();
    }

}
