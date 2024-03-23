package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.response.GetAllUserResponse;
import az.springbootlessons.faketweetapp.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-23T16:09:07+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapGetAllUserResponseToUser(GetAllUserResponse getAllUserResponse) {
        if ( getAllUserResponse == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( getAllUserResponse.getUsername() );

        return user.build();
    }

    @Override
    public GetAllUserResponse mapUserToGetAllUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        GetAllUserResponse.GetAllUserResponseBuilder getAllUserResponse = GetAllUserResponse.builder();

        getAllUserResponse.username( user.getUsername() );

        return getAllUserResponse.build();
    }
}
