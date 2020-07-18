package ge.cugu.post.breed;

import ge.cugu.domain.post.Breed;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BreedEntityMapper {

    BreedEntity toEntity(Breed domain);
    Breed toDomain(BreedEntity entity);
}
