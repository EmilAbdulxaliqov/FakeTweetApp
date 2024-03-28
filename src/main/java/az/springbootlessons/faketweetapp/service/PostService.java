package az.springbootlessons.faketweetapp.service;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.exception.PostNotFoundException;
import az.springbootlessons.faketweetapp.exception.UserNotFoundException;
import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.mapper.UserMapper;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.PostRepository;
import az.springbootlessons.faketweetapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
//    private final UserRepository userRepository;
    private final PostMapper postMapper;
    private final UserService userService;
    private final UserMapper userMapper;


    public void addPost(PostRequestDto postDto,Long userId) {
//        User user = userMapper.mapGetAllUserResponseToUser(userService.getUserById(userId));
//        Don't forget user_id and then you will get an error object references an unsaved transient instance - save the transient instance before flushing
        User user = userService.findById(userId);
        Post post = postMapper.dtoToPost(postDto);
        post.setUser(user);
        postRepository.save(post);
    }

    public List<GetPostResponse> getAllPosts() {
        List<Post> post = postRepository.findAll();
        return post.stream().map(postMapper::postToDto).collect(Collectors.toList());
    }

    public GetPostResponse getPostByIdDto(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found"));
        return postMapper.postToDto(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    public List<GetPostResponse> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId).stream().map(postMapper::postToDto).collect(Collectors.toList());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public void updatePost(Long id, PostRequestDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post not found"));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
    }

    public List<GetPostResponse> getPostsByLikes(Long userId) {
        return postRepository.findByLikesByUser(userId).stream().map(postMapper::postToDto).collect(Collectors.toList());
    }
}
