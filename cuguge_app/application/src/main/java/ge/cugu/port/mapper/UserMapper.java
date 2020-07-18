package ge.cugu.port.mapper;

import ge.cugu.domain.user.User;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "img", expression = "java(domain.getImg() == null ? null : domain.getImg().getFullPath())")
    UserResponseModel toUserResponse(User domain);
}
