package az.springbootlessons.faketweetapp.mapper;


import az.springbootlessons.faketweetapp.dto.response.GetAllUserResponse;
import az.springbootlessons.faketweetapp.model.User;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User mapGetAllUserResponseToUser(GetAllUserResponse getAllUserResponse);
    GetAllUserResponse mapUserToGetAllUserResponse(User user);
}
