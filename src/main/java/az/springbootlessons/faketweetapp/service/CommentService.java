package az.springbootlessons.faketweetapp.service;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.mapper.CommentMapper;
import az.springbootlessons.faketweetapp.model.Comment;
import az.springbootlessons.faketweetapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository , CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }


    public List<CommentResponseDto> getCommentByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public void addComment(CommentRequestDto commentDto) {
        Comment comment = commentMapper.dtoToComment(commentDto);
        commentRepository.save(comment);
    }

}
