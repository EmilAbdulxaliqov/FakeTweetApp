package az.springbootlessons.faketweetapp.dto.response;

import az.springbootlessons.faketweetapp.model.Post;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllUserResponse {
    Long id;
    String username;
    List<Post> posts;
}
