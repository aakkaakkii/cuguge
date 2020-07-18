package ge.cugu.port.out.post;

import ge.cugu.domain.post.Breed;

public interface BreedPort {
    Breed findById(Long id);
    Breed save(Breed breed);
    void deleteById(Long id);
}
