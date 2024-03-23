package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.model.Like;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private LikeRepository likeRepository;
    private PostService postService;

    private UserService userService;

    public LikeService(PostService postService, UserService userService, LikeRepository likeRepository) {
        this.postService = postService;
        this.userService = userService;
        this.likeRepository = likeRepository;
    }

    public void likePost(Long postId, Long userId) {
        Post post = postService.getPostById(postId);
        User user = userService.getUserById(userId);

        if (post == null && user == null) {
            throw new RuntimeException("Post not found");
        }
        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        likeRepository.save(like);
    }

    public void unlikePost(Long postId, Long userId) {
        likeRepository.deleteByPostIdAndUserId(postId, userId);
    }



}
