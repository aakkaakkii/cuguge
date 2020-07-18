package ge.cugu.service.post;

import ge.cugu.port.in.post.LoadPostUseCase;
import ge.cugu.port.mapper.CreatePostMapper;
import ge.cugu.port.model.responsemodel.post.PostResponse;
import ge.cugu.port.out.post.PostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadPostUseCaseImpl implements LoadPostUseCase {

    private final PostPort postPort;
    private final CreatePostMapper createPostMapper;

    @Override
    public List<PostResponse> loadPosts(int start, int limit) {
        return postPort.findAll(start, limit).stream()
                .map(createPostMapper::toPostResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PostResponse getPost(Long id) {
        return createPostMapper.toPostResponse(postPort.findById(id));
    }

    @Override
    public long getTotal() {
        return postPort.getCount();
    }
}
