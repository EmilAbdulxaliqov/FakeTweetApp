package az.springbootlessons.faketweetapp.dto.request;

import lombok.Data;

@Data
public class PostRequestDto {
    private String title;
    private String content;
}
