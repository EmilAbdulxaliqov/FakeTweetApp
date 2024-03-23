package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.mapper.CommentMapper;
import az.springbootlessons.faketweetapp.mapper.PostMapper;
import az.springbootlessons.faketweetapp.mapper.UserMapper;
import az.springbootlessons.faketweetapp.model.Comment;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import az.springbootlessons.faketweetapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostService postService;
    private final UserService userService;
    private final CommentMapper commentMapper;
    private final PostMapper postMapper;
    private final UserMapper userMapper;

    public List<CommentResponseDto> getCommentByPostId(Long postId) {
        return commentRepository.findByPostId(postId).stream().map(commentMapper::commentToDto).toList();
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void addComment(CommentRequestDto commentDto, Long postId, Long userId) {
        Post postDto = postMapper.dtoToPost(postService.getPostByIdDto(postId));
        User user = userMapper.mapGetAllUserResponseToUser(userService.getUserById(userId));
        Comment comment = commentMapper.dtoToComment(commentDto);
        comment.setPost(postDto);
        comment.setUser(user);
        commentRepository.save(comment);
    }

}
