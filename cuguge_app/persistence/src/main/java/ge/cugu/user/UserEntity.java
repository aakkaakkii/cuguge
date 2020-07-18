package ge.cugu.user;

import com.sun.istack.NotNull;
import ge.cugu.domain.user.User;
import ge.cugu.image.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @NotNull
    private String username;
    private String password;
    private String mail;
    private boolean active;
    @OneToOne
    private ImageEntity img;
    @ElementCollection(targetClass = User.Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<User.Role> roles;
    @Enumerated(EnumType.STRING)
    private User.Type type;

}
