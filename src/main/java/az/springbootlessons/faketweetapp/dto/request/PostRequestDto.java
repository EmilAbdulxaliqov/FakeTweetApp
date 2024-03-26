package az.springbootlessons.faketweetapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostRequestDto {
    @NotBlank(message = "Title is required and must not be empty!")
    @Size(min = 3, message = "Title must be at least 3 characters long!")
    @Size(max = 255, message = "Title must be less than 255 characters long!")
    private String title;
    @NotBlank(message = "Content is required and must not be empty!")
    @Size(min = 1, message = "Content must be at least 3 characters long!")
    @Size(max = 255, message = "Content must be less than 255 characters long!")
    private String content;
}
