package ge.cugu.service.post;

import ge.cugu.domain.image.Image;
import ge.cugu.domain.post.Post;
import ge.cugu.port.in.post.CreatePostUseCase;
import ge.cugu.port.model.requestmodel.image.ImageRequest;
import ge.cugu.port.model.requestmodel.post.CreatePostRequest;
import ge.cugu.port.out.file.FileStoragePort;
import ge.cugu.port.out.image.ImagePort;
import ge.cugu.port.out.post.PostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {

    private final PostPort postPort;
    private final ImagePort imagePort;
    private final FileStoragePort fileStoragePort;

    @Override
    public void createPost(CreatePostRequest createPostRequest) {

        List<Image> images = new ArrayList<>();

        for (ImageRequest image : createPostRequest.getImages()) {
//            imagePort.save(fileStoragePort.save("", image.getName(), Optional.of(image.getMetaData()), image.getInputStream()));
            images.add(fileStoragePort.save(FileStoragePort.POST_IMAGE,
                    String.format("%s-%s", UUID.randomUUID(), image.getName()),
                    Optional.of(image.getMetaData()),
                    image.getInputStream()));
        }

        postPort.save(Post.builder()
                .description(createPostRequest.getDescription())
                .title(createPostRequest.getTitle())
                .images(images)
                .createDate(createPostRequest.getCreateDate())
                .build()
        );
    }
}
