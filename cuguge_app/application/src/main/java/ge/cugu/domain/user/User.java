package ge.cugu.domain.user;

import ge.cugu.domain.image.Image;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String mail;
    private boolean active;
    private Image img;
    private Set<Role> roles;
    private Type type;

    public void activateUser() {
        this.active = true;
    }

    public enum Role {
        USER, ADMIN;

        public String getRole() {
            return name();
        }
    }

    public enum Type {
        FACEBOOK, GOOGLE, DEFAULT;

        public String getType() {
            return name();
        }
    }

}
