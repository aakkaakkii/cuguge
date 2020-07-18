package ge.cugu.port.mapper;

import ge.cugu.domain.image.Image;
import ge.cugu.domain.post.Post;
import ge.cugu.port.model.responsemodel.post.PostResponse;
import ge.cugu.port.out.file.FileStoragePort;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CreatePostMapper {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    protected FileStoragePort fileStoragePort;

    @Mapping(target = "specie", expression = "java(domain.getBreed() == null ? null : domain.getBreed().getName())")
    @Mapping(target = "breed", expression = "java(domain.getSpecie() == null ? null : domain.getSpecie().getName())")
    @Mapping(target = "images", expression = "java(convertImages(domain.getImages()))")
    @Mapping(target = "creator", expression = "java(userMapper.toUserResponse(domain.getCreator()))")
    public abstract PostResponse toPostResponse(Post domain);

    protected List<String> convertImages(List<Image> images){
        return images == null ? null : images.stream()
                .map(image -> fileStoragePort.getBucketPath() + image.getFullPath())
                .collect(Collectors.toList());
    }
}
