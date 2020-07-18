package ge.cugu.post.specie;

import ge.cugu.domain.post.Specie;
import ge.cugu.port.out.post.SpeciePort;
import ge.cugu.post.breed.BreedPersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpeciePersistenceAdapter implements SpeciePort {

    private final SpecieRepository specieRepository;
    private final SpecieEntityMapper specieEntityMapper;

    @Override
    public List<Specie> findAll() {
        return specieRepository.findAll()
                .stream().map(specieEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Specie findById(Long id) {
        return specieEntityMapper.toDomain(specieRepository.getOne(id));
    }

    @Override
    public Specie save(Specie specie) {
        return specieEntityMapper.toDomain(specieRepository.save(specieEntityMapper.toEntity(specie)));
    }

    @Override
    public void deleteById(Long id) {
        specieRepository.deleteById(id);
    }

}
