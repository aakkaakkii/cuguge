package ge.cugu.user;

import ge.cugu.domain.user.User;
import ge.cugu.image.ImageEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    ImageEntityMapper imageMapper = Mappers.getMapper( ImageEntityMapper.class );

    @Mapping(target = "img", expression = "java(imageMapper.toDomain(entity.getImg()))")
    User toDomain(UserEntity entity);
    @Mapping(target = "img", expression = "java(imageMapper.toEntity(domain.getImg()))")
    UserEntity toEntity(User domain);

}
