package az.springbootlessons.faketweetapp.controller;


import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @GetMapping
    public List<GetPostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public GetPostResponse getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/{userId}")
    public List<GetPostResponse> getPostsByUserId(@PathVariable Long userId) {
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public void addPost(@RequestBody PostRequestDto postDto) {
        postService.addPost(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postDto) {
        postService.updatePost(id, postDto);
    }
}
