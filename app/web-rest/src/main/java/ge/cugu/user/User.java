package ge.cugu.user;

import ge.cugu.port.in.user.ListUsersUseCase;
import ge.cugu.port.in.user.RegisterUserUseCase;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class User {
    private final RegisterUserUseCase registerUserUseCase;
    private final ListUsersUseCase listUsersUseCase;

    @GetMapping
    public List<UserResponseModel> loadUsers(){
        return listUsersUseCase.loadUsers();
    }

    @GetMapping("/tesr")
    public String loadUsers2(){
        return "asdasdasdas";
    }

}
