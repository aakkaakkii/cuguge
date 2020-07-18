package ge.cugu.port.model.responsemodel.post;

import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Long id;
    private String title;
    private String description;
    private String specie;
    private String breed;
    private int age;
    private List<String> images;
    private UserResponseModel creator;
    private Date createDate;
}
