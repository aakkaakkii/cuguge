package ge.cugu;

import ge.cugu.port.out.authentication.AuthUtilPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthUtil implements AuthUtilPort {
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean checkPassword(String password, String passwordFromDb) {
        return passwordEncoder.matches(password, passwordFromDb);
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


}
