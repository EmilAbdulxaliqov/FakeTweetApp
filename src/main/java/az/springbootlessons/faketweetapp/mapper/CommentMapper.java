package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.request.CommentRequestDto;
import az.springbootlessons.faketweetapp.dto.response.CommentResponseDto;
import az.springbootlessons.faketweetapp.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    Comment dtoToComment(CommentRequestDto dto);
    CommentResponseDto commentToDto(Comment comment);
}
