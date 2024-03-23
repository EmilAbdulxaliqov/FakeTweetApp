package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.mapper.CommentMapper;
import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.model.Comment;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private PostService postService;
    private CommentMapper commentMapper;

    private PostMapper postMapper;


    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, PostService postService, PostMapper postMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
        this.postService = postService;
        this.postMapper = postMapper;
    }


    public List<CommentResponseDto> getCommentByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void addComment(CommentRequestDto commentDto , Long postId, Long userId) {
        Post postDto = postService.getPostById(postId);
        User user = UserService.getUserById(userId);
        if (postDto == null && user == null) {
            throw new RuntimeException("Post not found");
        }

        Comment comment = commentMapper.dtoToComment(commentDto);
        comment.setPost( postDto);
        comment.setUser(user);
        commentRepository.save(comment);

    }

}
