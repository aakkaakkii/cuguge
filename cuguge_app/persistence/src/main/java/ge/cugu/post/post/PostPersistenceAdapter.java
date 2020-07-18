package ge.cugu.post.post;

import ge.cugu.domain.post.Post;
import ge.cugu.port.out.post.PostPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPort {

    private final PostRepository postRepository;
    private final PostEntityMapper postEntityMapper;

    @Override
    public List<Post> findAll(int start, int limit) {
        return postRepository.findAll(PageRequest.of(start / limit, limit))
                .stream().map(postEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return postEntityMapper.toDomain(postRepository.getOne(id));
    }

    @Override
    public Post save(Post post) {
        return postEntityMapper.toDomain(postRepository.save(postEntityMapper.toEntity(post)));
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public long getCount() {
        return postRepository.count();
    }

}
