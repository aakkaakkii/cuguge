package ge.cugu.user;

import ge.cugu.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByMail(String mail);
    List<UserEntity> findByMailOrUsername(String mail, String username);
    @Query("select u from UserEntity u where (u.username =:usernameOrMail or u.mail =:usernameOrMail) and u.type=:type")
    UserEntity findByMailOrUsernameOrType(@Param("usernameOrMail") String usernameOrMail,
                                          @Param("type")User.Type type);
}
