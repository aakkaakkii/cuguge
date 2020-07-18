package ge.cugu.port.model.requestmodel.post;

import ge.cugu.domain.image.Image;
import ge.cugu.domain.post.Breed;
import ge.cugu.domain.post.Specie;
import ge.cugu.domain.user.User;
import ge.cugu.port.model.requestmodel.image.ImageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String description;
//    private int age;

    private Date createDate;
    private List<ImageRequest> images;
//    private Specie specie;
//    private Breed breed;
}
