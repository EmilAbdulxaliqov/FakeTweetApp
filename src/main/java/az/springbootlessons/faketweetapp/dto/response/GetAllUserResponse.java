package az.springbootlessons.faketweetapp.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllUserResponse {
    String username;
//    List<Post> posts;
}
