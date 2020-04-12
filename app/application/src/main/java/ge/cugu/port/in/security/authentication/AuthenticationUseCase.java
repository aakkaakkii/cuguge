package ge.cugu.port.in.security.authentication;

import ge.cugu.port.in.security.authentication.exception.LoginFailedException;
import ge.cugu.port.model.requestmodel.authentication.AuthenticationRequestModel;
import ge.cugu.port.model.requestmodel.authentication.OAuthRequestModel;

public interface AuthenticationUseCase {
    String login(AuthenticationRequestModel requestDto) throws LoginFailedException;
    String googleAut(OAuthRequestModel requestDto)throws LoginFailedException;
}
