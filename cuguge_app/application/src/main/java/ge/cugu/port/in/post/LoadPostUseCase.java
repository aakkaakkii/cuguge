package ge.cugu.port.in.post;

import ge.cugu.port.model.requestmodel.post.CreatePostRequest;
import ge.cugu.port.model.responsemodel.post.PostResponse;

import java.util.List;

public interface LoadPostUseCase {
    List<PostResponse> loadPosts(int start, int limit);
    PostResponse getPost(Long id);
    long getTotal();
}
