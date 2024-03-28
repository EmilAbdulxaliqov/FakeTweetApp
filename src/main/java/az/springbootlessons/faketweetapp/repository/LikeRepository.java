package az.springbootlessons.faketweetapp.repository;

import az.springbootlessons.faketweetapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Modifying
    @Query("delete from likes l where l.post.id =:postId and l.user.id =:userId")
    void deleteByPostIdAndUserId(Long postId, Long userId);
}
