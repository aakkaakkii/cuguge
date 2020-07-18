package ge.cugu.port.out.post;

import ge.cugu.domain.post.Post;

import java.util.List;

public interface PostPort {
    List<Post> findAll(int start, int limit);
    Post findById(Long id);
    Post save(Post post);
    void deleteById(Long id);
    long getCount();
}
