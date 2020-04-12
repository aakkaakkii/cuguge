package ge.cugu.port.model.responsemodel.user;

import ge.cugu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseModel {
    private Long id;
    private String username;
    private String mail;
    private boolean active;
    private String img;
    private Set<User.Role> roles;

    public static UserResponseModel fromDomain(User domain) {
        return UserResponseModel.builder()
                .id(domain.getId())
                .username(domain.getUsername())
                .mail(domain.getMail())
                .active(domain.isActive())
                .img(domain.getImg())
                .roles(domain.getRoles())
                .build();
    }
}
