package ge.cugu.user.activationcode;

import ge.cugu.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "activation_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivationCodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String activationCode;
    @OneToOne
    private UserEntity user;
}