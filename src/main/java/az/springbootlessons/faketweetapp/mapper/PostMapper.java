package az.springbootlessons.faketweetapp.mapper;

import az.springbootlessons.faketweetapp.dto.request.PostRequestDto;
import az.springbootlessons.faketweetapp.dto.response.GetPostResponse;
import az.springbootlessons.faketweetapp.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    Post dtoToPost(PostRequestDto dto);
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "userId", source = "user.id")
    GetPostResponse postToDto(Post post);
    Post dtoToPost(GetPostResponse dto);
}
