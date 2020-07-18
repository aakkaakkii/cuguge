package ge.cugu.user.activationcode;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.user.UserEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActivationCodeEntityMapper {

    UserEntityMapper userMapper = Mappers.getMapper( UserEntityMapper.class );

    @Mapping(target = "user", expression = "java(userMapper.toDomain(entity.getUser()))")
    ActivationCode toDomain(ActivationCodeEntity entity);
    @Mapping(target = "user", expression = "java(userMapper.toEntity(domain.getUser()))")
    ActivationCodeEntity toEntity(ActivationCode domain);
}
