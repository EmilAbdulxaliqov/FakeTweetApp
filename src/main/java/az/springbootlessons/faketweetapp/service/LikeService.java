package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.mapper.UserMapper;
import az.springbootlessons.faketweetapp.model.Like;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostService postService;
    private final UserService userService;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public void likePost(Long postId, Long userId) {
        Post post = postMapper.dtoToPost(postService.getPostByIdDto(postId));
        User user = userMapper.mapGetAllUserResponseToUser(userService.getUserById(userId));
        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        likeRepository.save(like);
    }

    @Transactional
    public void unlikePost(Long postId, Long userId) {
        likeRepository.deleteByPostIdAndUserId(postId, userId);
    }



}
