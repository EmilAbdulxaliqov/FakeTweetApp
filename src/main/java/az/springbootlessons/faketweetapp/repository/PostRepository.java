package az.springbootlessons.faketweetapp.repository;



import az.springbootlessons.faketweetapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{
  List<Post> findByUserId(Long userId);
}
