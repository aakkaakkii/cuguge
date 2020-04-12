package ge.cugu.service.security.authentication;

import ge.cugu.domain.user.User;
import ge.cugu.port.in.security.authentication.AuthenticationUseCase;
import ge.cugu.port.in.security.authentication.exception.LoginFailedException;
import ge.cugu.port.model.requestmodel.authentication.AuthenticationRequestModel;
import ge.cugu.port.model.requestmodel.authentication.OAuthRequestModel;
import ge.cugu.port.out.authentication.AuthUtilPort;
import ge.cugu.port.out.authentication.JwtTokenProviderPort;
import ge.cugu.port.out.authentication.OAuthPort;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationUseCase {
    private final JwtTokenProviderPort jwtTokenProviderPort;
    private final OAuthPort oAuthPort;
    private final UserPort userPort;
    private final AuthUtilPort authUtilPort;

    @Override
    public String login(AuthenticationRequestModel requestDto) throws LoginFailedException {
        User user = userPort.findByUsername(requestDto.getUsername());

        if(user == null || !authUtilPort.checkPassword(requestDto.getPassword(), user.getPassword())){
            throw new LoginFailedException();
        }

        return jwtTokenProviderPort.createToken(requestDto.getUsername(), user.getRoles());
    }

    @Override
    public String googleAut(OAuthRequestModel oAuthRequestModel) {
        User user = oAuthPort.googleAuth(oAuthRequestModel.getToken());
        User userFromDb = userPort.findByUsername(user.getUsername());

        if (userFromDb == null) {
            user.setActive(true);
            user.setType(User.Type.GOOGLE);
            userFromDb = userPort.add(user);
        }

        return jwtTokenProviderPort.createToken(userFromDb.getUsername(), userFromDb.getRoles());
    }
}