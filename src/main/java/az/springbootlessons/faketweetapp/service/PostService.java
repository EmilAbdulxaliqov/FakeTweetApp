package az.springbootlessons.faketweetapp.service;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;
    public PostService(PostRepository postRepository , PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public void addPost(PostRequestDto postDto) {
        User user = UserService.UserGet(postDto.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Post post = postMapper.dtoToPost(postDto);
        post.setUser(user);
        postRepository.save(post);
    }

}
