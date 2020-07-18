package ge.cugu.domain.image;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image {
    private Long id;
    private String fullPath;
    private String name;
}
