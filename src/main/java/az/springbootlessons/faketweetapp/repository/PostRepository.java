package az.springbootlessons.faketweetapp.repository;

import az.springbootlessons.faketweetapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

}
