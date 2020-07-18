package ge.cugu.port.in.post;

import ge.cugu.port.model.requestmodel.post.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface CreatePostUseCase {

    void createPost(CreatePostRequest createPostRequest);
}
