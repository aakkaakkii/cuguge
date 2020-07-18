package ge.cugu.post.specie;

import ge.cugu.domain.post.Breed;
import ge.cugu.domain.post.Specie;
import ge.cugu.post.breed.BreedEntity;
import ge.cugu.post.breed.BreedEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface SpecieEntityMapper {
    BreedEntityMapper breedMapper = Mappers.getMapper(BreedEntityMapper.class);

    @Mapping(target = "breeds", expression = "java(toBreeds(entity.getBreeds()))")
    Specie toDomain(SpecieEntity entity);
    @Mapping(target = "breeds", expression = "java(toBreedsEntities(domain.getBreeds()))")
    SpecieEntity toEntity(Specie domain);

    default List<Breed> toBreeds(List<BreedEntity> breeds) {
        return breeds == null ? null : breeds.stream()
                .map(breedMapper::toDomain)
                .collect(Collectors.toList());
    }

    default List<BreedEntity> toBreedsEntities(List<Breed> breeds) {
        return breeds == null ? null : breeds.stream()
                .map(breedMapper::toEntity)
                .collect(Collectors.toList());
    }
}
