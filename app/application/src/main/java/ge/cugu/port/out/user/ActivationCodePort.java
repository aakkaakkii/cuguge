package ge.cugu.port.out.user;

import ge.cugu.domain.user.ActivationCode;

public interface ActivationCodePort {
    ActivationCode findByCode(String activationCode);
    ActivationCode add(ActivationCode activationCode);
    void delete(Long id);
}
