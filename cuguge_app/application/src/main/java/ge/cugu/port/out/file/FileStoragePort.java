package ge.cugu.port.out.file;

import ge.cugu.domain.image.Image;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

public interface FileStoragePort {
    String POST_IMAGE="postImage";


    Image save(String path, String filename,
               Optional<Map<String, String>> optionalMetaData,
               InputStream is);

    byte[] download(String path, String key);
    String getBucketPath();
}
