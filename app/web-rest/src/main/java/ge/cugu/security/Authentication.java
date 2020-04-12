package ge.cugu.security;

import ge.cugu.port.in.security.authentication.AuthenticationUseCase;
import ge.cugu.port.in.security.authentication.exception.LoginFailedException;
import ge.cugu.port.model.requestmodel.authentication.AuthenticationRequestModel;
import ge.cugu.port.model.requestmodel.authentication.OAuthRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authentication {
    private final AuthenticationUseCase authenticationUseCase;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestModel requestModel) throws LoginFailedException {
        return ResponseEntity.ok(authenticationUseCase.login(requestModel));
    }

    @PostMapping("/facebook")
    public ResponseEntity facebookAuth(@RequestBody AuthenticationRequestModel requestModel) throws LoginFailedException {
        return ResponseEntity.ok(authenticationUseCase.login(requestModel));
    }

    @PostMapping("/google")
    public ResponseEntity googleAuth(@RequestBody OAuthRequestModel requestModel) throws LoginFailedException {
        return ResponseEntity.ok(authenticationUseCase.googleAut(requestModel));
    }
}
