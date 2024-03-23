package az.springbootlessons.faketweetapp.controller;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;



    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{postId}/user/{userId}")
    public void addComment(@RequestBody CommentRequestDto commentDto, @PathVariable Long postId, @PathVariable Long userId ) {
        commentService.addComment(commentDto, postId, userId);
    }
    @GetMapping("/{postId}")
    public List<CommentResponseDto> getCommentByPostId(@PathVariable Long postId) {
        return commentService.getCommentByPostId(postId);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

}
