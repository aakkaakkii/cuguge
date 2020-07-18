package ge.cugu.user.activationcode;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.port.out.user.ActivationCodePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivationCodePersistenceAdapter implements ActivationCodePort {

    private final ActivationCodeRepository activationCodeRepository;
    private final ActivationCodeEntityMapper activationCodeEntityMapper;

    @Override
    public ActivationCode findByCode(String activationCode) {
        return activationCodeEntityMapper.toDomain(activationCodeRepository.findByActivationCode(activationCode));
    }

    @Override
    public ActivationCode add(ActivationCode activationCode) {
        return activationCodeEntityMapper.toDomain(
                activationCodeRepository.save(activationCodeEntityMapper.toEntity(activationCode)));
    }

    @Override
    public void delete(Long id) {
        activationCodeRepository.deleteById(id);
    }
}
