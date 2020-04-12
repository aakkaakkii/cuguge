package ge.cugu.user.activationcode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeRepository extends JpaRepository<ActivationCodeEntity, Long> {
    ActivationCodeEntity findByActivationCode(String activationCode);
}
