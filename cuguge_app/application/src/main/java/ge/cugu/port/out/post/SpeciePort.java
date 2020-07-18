package ge.cugu.port.out.post;

import ge.cugu.domain.post.Specie;

import java.util.List;

public interface SpeciePort {
    List<Specie> findAll();
    Specie findById(Long id);
    Specie save(Specie specie);
    void deleteById(Long id);
}
