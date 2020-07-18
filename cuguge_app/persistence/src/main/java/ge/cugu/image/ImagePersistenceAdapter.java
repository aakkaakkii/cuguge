package ge.cugu.image;

import ge.cugu.domain.image.Image;
import ge.cugu.port.out.image.ImagePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImagePersistenceAdapter implements ImagePort {

    private final ImageRepository imageRepository;
    private final ImageEntityMapper imageEntityMapper;

    @Override
    public Image findById(Long id) {
        return imageEntityMapper.toDomain(imageRepository.getOne(id));
    }

    @Override
    public Image findByName(String name) {
        return imageEntityMapper.toDomain(imageRepository.findByName(name));
    }

    @Override
    public Image save(Image image) {
        return imageEntityMapper.toDomain(imageRepository.save(imageEntityMapper.toEntity(image)));
    }

    @Override
    public void deleteById(Long id) {
        imageRepository.deleteById(id);
    }
}
