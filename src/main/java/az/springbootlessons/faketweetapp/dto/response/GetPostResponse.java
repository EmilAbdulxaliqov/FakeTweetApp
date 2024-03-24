package az.springbootlessons.faketweetapp.dto.response;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetPostResponse {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String username;
    private Integer likeCount;
}
