package ge.cugu.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivationCode {
    private Long id;
    private String activationCode;
    private User user;
}
