package az.springbootlessons.faketweetapp.service;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<GetPostResponse> getAllPosts() {
        return postRepository.findAll().stream().map(post -> GetPostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUser().getId())
                .userName(post.getUser().getUsername())
                .build()).collect(Collectors.toList());
    }

    public GetPostResponse getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        return GetPostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUser().getId())
                .userName(post.getUser().getUsername())
                .build();
    }

    public List<GetPostResponse> getPostsByUserId(Long userId) {
        return  postRepository.findByUserId(userId).stream().map(post -> GetPostResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .userId(post.getUser().getId())
                .userName(post.getUser().getUsername())
                .build()).collect(Collectors.toList());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public void updatePost(Long id, PostRequestDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
    }



}