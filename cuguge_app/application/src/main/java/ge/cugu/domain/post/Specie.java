package ge.cugu.domain.post;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Specie {
    private Long id;
    private String name;
    private List<Breed> breeds;
}
