package ge.cugu.post;

import ge.cugu.port.in.post.CreatePostUseCase;
import ge.cugu.port.in.post.LoadPostUseCase;
import ge.cugu.port.model.requestmodel.image.ImageRequest;
import ge.cugu.port.model.requestmodel.post.CreatePostRequest;
import ge.cugu.port.model.responsemodel.post.PostResponse;
import ge.cugu.util.PaginatedListWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@CrossOrigin
public class Post {

    private final CreatePostUseCase createPostUseCase;
    private final LoadPostUseCase loadPostUseCase;

    @GetMapping
    public PaginatedListWrapper<PostResponse> loadPosts() {
        // TODO: needs refactoring

        return PaginatedListWrapper.<PostResponse>builder()
                .start(0)
                .limit(0)
                .total(loadPostUseCase.getTotal())
                .list(loadPostUseCase.loadPosts(0, Integer.MAX_VALUE))
                .build();
    }

    @GetMapping("{id}")
    public PostResponse getPost(@PathVariable Long id){
        return loadPostUseCase.getPost(id);
    }

    @PostMapping
    public void createPost(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam MultipartFile[] file) throws IOException {
        List<ImageRequest> imageRequests = new ArrayList<>();

        for (MultipartFile f : file) {
            Map<String, String> metadata = new HashMap<>();

            metadata.put("Content-Type", f.getContentType());
            metadata.put("Content-Length", String.valueOf(f.getSize()));

            imageRequests.add(ImageRequest.builder()
                    .name(f.getName())
                    .inputStream(f.getInputStream())
                    .contentType(f.getContentType())
                    .metaData(metadata)
                    .build());
        }

        createPostUseCase.createPost(CreatePostRequest.builder()
                .createDate(new Date())
                .description(description)
                .title(title)
                .images(imageRequests)
                .build());
    }
}

