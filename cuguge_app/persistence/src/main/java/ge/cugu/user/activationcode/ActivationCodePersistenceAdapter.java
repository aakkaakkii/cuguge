package ge.cugu.user.activationcode;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.port.out.user.ActivationCodePort;
import ge.cugu.user.UserPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivationCodePersistenceAdapter implements ActivationCodePort {
    private final ActivationCodeRepository activationCodeRepository;

    @Override
    public ActivationCode findByCode(String activationCode) {
        return toDomain(activationCodeRepository.findByActivationCode(activationCode));
    }

    @Override
    public ActivationCode add(ActivationCode activationCode) {
        return toDomain(activationCodeRepository.save(fromDomain(activationCode)));
    }

    @Override
    public void delete(Long id) {
        activationCodeRepository.deleteById(id);
    }

    public static ActivationCode toDomain(ActivationCodeEntity entity) {
        return ActivationCode.builder()
                .id(entity.getId())
                .activationCode(entity.getActivationCode())
                .user(UserPersistenceAdapter.toDomain(entity.getUser()))
                .build();
    }

    public static ActivationCodeEntity fromDomain(ActivationCode domain) {
        return ActivationCodeEntity.builder()
                .id(domain.getId())
                .activationCode(domain.getActivationCode())
                .user(UserPersistenceAdapter.fromDomain(domain.getUser()))
                .build();
    }
}
