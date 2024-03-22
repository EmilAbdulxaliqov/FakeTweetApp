package az.springbootlessons.faketweetapp.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetPostResponse {
    private String title;
    private String content;
    private Long userId;
    private String userName;

}
