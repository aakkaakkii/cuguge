package ge.cugu.domain.post;

import ge.cugu.domain.image.Image;
import ge.cugu.domain.user.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Post {
    private Long id;
    private String title;
    private String description;
    private Specie specie;
    private Breed breed;
    private int age;
    private List<Image> images;
    private User creator;
    private User petOwner;
    private Date createDate;
}
