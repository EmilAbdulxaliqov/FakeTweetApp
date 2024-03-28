package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.model.Comment;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T19:46:35+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment dtoToComment(CommentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.content( dto.getContent() );

        return comment.build();
    }

    @Override
    public CommentResponseDto commentToDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto.CommentResponseDtoBuilder commentResponseDto = CommentResponseDto.builder();

        commentResponseDto.postId( commentPostId( comment ) );
        commentResponseDto.userId( commentUserId( comment ) );
        commentResponseDto.username( commentUserUsername( comment ) );
        commentResponseDto.id( comment.getId() );
        commentResponseDto.content( comment.getContent() );

        return commentResponseDto.build();
    }

    private Long commentPostId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Post post = comment.getPost();
        if ( post == null ) {
            return null;
        }
        Long id = post.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long commentUserId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String commentUserUsername(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        User user = comment.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
