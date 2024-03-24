package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.service.LikeService;
import az.springbootlessons.faketweetapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final LikeService likeService;

    @GetMapping
    public List<GetPostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public GetPostResponse getPostById(@PathVariable Long id) {
        return postService.getPostByIdDto(id);
    }

    @GetMapping("/user/{userId}")
    public List<GetPostResponse> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @PostMapping("/user/{userId}")
    public void addPost(@RequestBody PostRequestDto postDto,@PathVariable Long userId) {
        postService.addPost(postDto,userId);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postDto) {
        postService.updatePost(id, postDto);
    }
    @PostMapping("/{postId}/like/{userId}")
    public void likePost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.likePost(postId, userId);
    }
    @DeleteMapping("/{postId}/unlike/{userId}")
    public void unlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.unlikePost(postId, userId);
    }

}
