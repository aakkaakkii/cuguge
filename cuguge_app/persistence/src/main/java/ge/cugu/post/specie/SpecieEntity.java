package ge.cugu.post.specie;

import ge.cugu.post.breed.BreedEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<BreedEntity> breeds;
}
