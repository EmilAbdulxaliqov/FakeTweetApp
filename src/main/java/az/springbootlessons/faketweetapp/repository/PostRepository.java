package az.springbootlessons.faketweetapp.repository;



import az.springbootlessons.faketweetapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
  List<Post> findByUserId(Long userId);
  @Query("SELECT p FROM posts  p JOIN p.likes l WHERE l.user.id= :userId")
  List<Post> findByLikesByUser(Long userId);
}
