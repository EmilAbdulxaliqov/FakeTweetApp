package az.springbootlessons.faketweetapp.dto.response;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class GetPostResponse {
    private Long id;
    private String title;
    private String content;
    private Long userIdWhoCreatedPost;
    private String username;
    private Integer likeCount;
    private List<Long> likesId;
    private List<Long> usersIdWhoLikedPost;
}
