package az.springbootlessons.faketweetapp.dto.request;

import lombok.Data;

@Data
public class CommentRequestDto {
    private String content;
    private Long userId;
    private Long postId;
}