package az.springbootlessons.faketweetapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity(name = "posts")
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
    @JoinColumn(name = "user_id")
    @JsonIgnore
    User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    List<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
    List<Like> likes;
}
