package az.springbootlessons.faketweetapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jdk.jfr.Enabled;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String content;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    List<Comment> comments;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    List<Like> likes;
}
