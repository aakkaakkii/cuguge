package ge.cugu.port.out.authentication;

import ge.cugu.domain.user.User;

import java.util.Set;

public interface JwtTokenProviderPort {
    String createToken(String username, Set<User.Role> roles);
    boolean validateToken(String token);
}
