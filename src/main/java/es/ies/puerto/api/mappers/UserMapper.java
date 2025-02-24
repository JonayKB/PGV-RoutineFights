package es.ies.puerto.api.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.model.entity.User;
/**
 * UserMapper
 */
@Mapper(uses={RolMapper.class})
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public UserDto toUserDto(User user);

    public User toUser(UserDto userDto);

    public List<User> toUserList(List<UserDto> userDto);
}
