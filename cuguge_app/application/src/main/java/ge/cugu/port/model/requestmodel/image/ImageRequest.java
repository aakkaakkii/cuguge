package ge.cugu.port.model.requestmodel.image;

import lombok.*;

import java.io.InputStream;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest {
    private InputStream inputStream;
    private String contentType;
    private String name;
    private Map<String, String> metaData;
}
