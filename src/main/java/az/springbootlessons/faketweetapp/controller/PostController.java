package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.service.LikeService;
import az.springbootlessons.faketweetapp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final LikeService likeService;

    @GetMapping
    public ResponseEntity<List<GetPostResponse>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPostResponse> getPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.getPostByIdDto(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GetPostResponse>> getPostsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<String> addPost(@RequestBody PostRequestDto postDto, @PathVariable Long userId) {
        postService.addPost(postDto,userId);
        return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postDto) {
        postService.updatePost(id, postDto);
        return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
    }
    @PostMapping("/{postId}/like/{userId}")
    public ResponseEntity<String> likePost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.likePost(postId, userId);
        return new ResponseEntity<>("Post liked successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{postId}/unlike/{userId}")
    public ResponseEntity<String> unlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.unlikePost(postId, userId);
        return new ResponseEntity<>("Post unliked successfully", HttpStatus.OK);
    }

}
