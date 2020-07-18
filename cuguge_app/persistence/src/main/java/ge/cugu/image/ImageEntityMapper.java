package ge.cugu.image;

import ge.cugu.domain.image.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageEntityMapper {

    ImageEntity toEntity(Image domain);
    Image toDomain(ImageEntity entity);
}
