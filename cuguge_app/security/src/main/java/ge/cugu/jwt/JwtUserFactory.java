package ge.cugu.jwt;

import ge.cugu.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.isActive(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(Set<User.Role> roles) {
        return roles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getRole())
                ).collect(Collectors.toList());
    }
}
