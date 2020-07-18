package ge.cugu.post.post;

import ge.cugu.domain.image.Image;
import ge.cugu.domain.post.Post;
import ge.cugu.image.ImageEntity;
import ge.cugu.image.ImageEntityMapper;
import ge.cugu.post.breed.BreedEntityMapper;
import ge.cugu.user.UserEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PostEntityMapper {

    BreedEntityMapper breedMapper = Mappers.getMapper(BreedEntityMapper.class);
    UserEntityMapper userMapper = Mappers.getMapper(UserEntityMapper.class);
    ImageEntityMapper imageMapper = Mappers.getMapper(ImageEntityMapper.class);

    @Mapping(target = "images", expression = "java(toImages(entity.getImages()))")
    @Mapping(target = "breed", expression = "java(breedMapper.toDomain(entity.getBreed()))")
    @Mapping(target = "petOwner", expression = "java(userMapper.toDomain(entity.getPetOwner()))")
    @Mapping(target = "creator", expression = "java(userMapper.toDomain(entity.getCreator()))")
    Post toDomain(PostEntity entity);

    @Mapping(target = "images", expression = "java(toImageEntities(domain.getImages()))")
    @Mapping(target = "breed", expression = "java(breedMapper.toEntity(domain.getBreed()))")
    @Mapping(target = "petOwner", expression = "java(userMapper.toEntity(domain.getPetOwner()))")
    @Mapping(target = "creator", expression = "java(userMapper.toEntity(domain.getCreator()))")
    PostEntity toEntity(Post domain);

    default List<Image> toImages(List<ImageEntity> images) {
        return images == null ? null : images.stream()
                .map(imageMapper::toDomain)
                .collect(Collectors.toList());
    }

    default List<ImageEntity> toImageEntities(List<Image> images) {
        return images == null ? null : images.stream()
                .map(imageMapper::toEntity)
                .collect(Collectors.toList());
    }

}
