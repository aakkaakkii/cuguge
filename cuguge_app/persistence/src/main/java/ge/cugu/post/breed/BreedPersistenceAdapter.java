package ge.cugu.post.breed;

import ge.cugu.domain.post.Breed;
import ge.cugu.domain.post.Specie;
import ge.cugu.port.out.post.BreedPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BreedPersistenceAdapter implements BreedPort {

    private final BreedRepository breedRepository;
    private final BreedEntityMapper breedEntityMapper;

    @Override
    public Breed findById(Long id) {
        return breedEntityMapper.toDomain(breedRepository.getOne(id));
    }

    @Override
    public Breed save(Breed breed) {
        return breedEntityMapper.toDomain(breedRepository.save(breedEntityMapper.toEntity(breed)));
    }

    @Override
    public void deleteById(Long id) {
        breedRepository.deleteById(id);
    }

}
