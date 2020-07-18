package ge.cugu.port.out.image;

import ge.cugu.domain.image.Image;

public interface ImagePort {
    Image findById(Long id);
    Image findByName(String name);
    Image save(Image image);
    void deleteById(Long id);
}
