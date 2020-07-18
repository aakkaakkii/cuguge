package ge.cugu.post.post;

import ge.cugu.image.ImageEntity;
import ge.cugu.post.breed.BreedEntity;
import ge.cugu.post.specie.SpecieEntity;
import ge.cugu.user.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private SpecieEntity specie;
    @OneToOne(cascade = CascadeType.ALL)
    private BreedEntity breed;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ImageEntity> images;
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity creator;
    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity petOwner;
    private int age;
    private Date createDate;
}
