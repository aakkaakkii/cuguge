package ge.cugu.domain.post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Breed {
    private Long id;
    private String name;
}
