package es.ies.puerto.routineFights.api.mappers;

import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.model.Activity;
import es.ies.puerto.routineFights.model.Badge;
import es.ies.puerto.routineFights.model.Post;
import es.ies.puerto.routineFights.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Mapper(componentModel = "spring", uses = {PostMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);

}
