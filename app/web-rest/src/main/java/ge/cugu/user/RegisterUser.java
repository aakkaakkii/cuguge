package ge.cugu.user;

import ge.cugu.port.in.user.RegisterUserUseCase;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserAlreadyExists;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/registration")
@RequiredArgsConstructor
public class RegisterUser {
    private final RegisterUserUseCase registerUserUseCase;

    @PostMapping
    public UserResponseModel createUser(@RequestBody @Valid CreateUserRequestModel user)
            throws PasswordDidntMatchException, UserAlreadyExists {
        return registerUserUseCase.register(user);
    }


    @GetMapping("/activation/{code}")
    public ResponseEntity facebookAuth(@PathVariable String code) {
        registerUserUseCase.activate(code);
        return ResponseEntity.ok("success");
    }

}
