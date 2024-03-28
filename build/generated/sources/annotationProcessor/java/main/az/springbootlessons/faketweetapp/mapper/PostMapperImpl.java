package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.model.Post;
import az.springbootlessons.faketweetapp.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-28T05:59:45+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.6.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post dtoToPost(PostRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.title( dto.getTitle() );
        post.content( dto.getContent() );

        return post.build();
    }

    @Override
    public GetPostResponse postToDto(Post post) {
        if ( post == null ) {
            return null;
        }

        GetPostResponse.GetPostResponseBuilder getPostResponse = GetPostResponse.builder();

        getPostResponse.username( postUserUsername( post ) );
        getPostResponse.userIdWhoCreatedPost( postUserId( post ) );
        getPostResponse.id( post.getId() );
        getPostResponse.title( post.getTitle() );
        getPostResponse.content( post.getContent() );

        getPostResponse.likeCount( post.getLikes().size() );
        getPostResponse.likesId( post.getLikes().stream().map(like -> like.getId()).toList() );
        getPostResponse.usersIdWhoLikedPost( post.getLikes().stream().map(like -> like.getUser().getId()).toList() );

        return getPostResponse.build();
    }

    @Override
    public Post dtoToPost(GetPostResponse dto) {
        if ( dto == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.id( dto.getId() );
        post.title( dto.getTitle() );
        post.content( dto.getContent() );

        return post.build();
    }

    private String postUserUsername(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private Long postUserId(Post post) {
        if ( post == null ) {
            return null;
        }
        User user = post.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
