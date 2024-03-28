package az.springbootlessons.faketweetapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String content;
    private Long postId;
    private Long userId;
    private String username;
}
