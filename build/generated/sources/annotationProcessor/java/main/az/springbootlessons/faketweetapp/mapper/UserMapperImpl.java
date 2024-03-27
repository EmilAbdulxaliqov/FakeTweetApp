package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.response.GetAllUserResponse;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-27T23:29:48+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapGetAllUserResponseToUser(GetAllUserResponse getAllUserResponse) {
        if ( getAllUserResponse == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( getAllUserResponse.getId() );
        user.username( getAllUserResponse.getUsername() );
        List<Post> list = getAllUserResponse.getPosts();
        if ( list != null ) {
            user.posts( new ArrayList<Post>( list ) );
        }

        return user.build();
    }

    @Override
    public GetAllUserResponse mapUserToGetAllUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        GetAllUserResponse.GetAllUserResponseBuilder getAllUserResponse = GetAllUserResponse.builder();

        getAllUserResponse.id( user.getId() );
        getAllUserResponse.username( user.getUsername() );
        List<Post> list = user.getPosts();
        if ( list != null ) {
            getAllUserResponse.posts( new ArrayList<Post>( list ) );
        }

        return getAllUserResponse.build();
    }
}
