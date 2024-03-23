package az.springbootlessons.faketweetapp.repository;

import az.springbootlessons.faketweetapp.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

    void deleteByPostIdAndUserId(Long  postId, Long userId);
}
