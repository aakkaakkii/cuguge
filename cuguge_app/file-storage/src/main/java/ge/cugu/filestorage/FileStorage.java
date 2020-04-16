package ge.cugu.filestorage;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileStorage {

    private final AmazonS3 s3;

    public void save(String path, String filename,
                     Optional<Map<String, String>> optionalMetaData,
                     InputStream is) {
        ObjectMetadata metadata = new ObjectMetadata();

        optionalMetaData.ifPresent(map -> {
            if (!map.isEmpty()) {
                map.forEach(metadata::addUserMetadata);
            }
        });

        s3.putObject(path, filename, is, metadata);
    }

    public byte[] download(String path, String key) {
        try {
            S3Object object = s3.getObject(path, key);
            S3ObjectInputStream is = object.getObjectContent();
            return IOUtils.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException("Failed to download");
        }
    }
}
