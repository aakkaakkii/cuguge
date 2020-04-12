package ge.cugu.port.out.authentication;

import ge.cugu.domain.user.User;

public interface OAuthPort {
    User googleAuth(String token);
}
