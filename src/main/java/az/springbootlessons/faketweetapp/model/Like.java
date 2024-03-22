package az.springbootlessons.faketweetapp.model;


import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Like {
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Post post;
}
