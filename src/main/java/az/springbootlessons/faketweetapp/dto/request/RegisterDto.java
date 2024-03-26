package az.springbootlessons.faketweetapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterDto {
    @NotBlank(message = "Username is required and must not be empty!")
    @Size(min = 3, message = "Username must be at least 3 characters long!")
    @Size(max = 255, message = "Username must be less than 255 characters long!")
    String username;
    @NotBlank(message = "Password is required and must not be empty!")
    @Size(min = 8, message = "Password must be at least 8 characters long!")
    @Size(max = 255, message = "Password must be less than 255 characters long!")
    String password;
}
