package es.ies.puerto.routineFights.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.routineFights.api.dto.PostDTO;
import es.ies.puerto.routineFights.api.dto.RolDTO;
import es.ies.puerto.routineFights.model.Post;
import es.ies.puerto.routineFights.model.Rol;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO toDto(Post post);
    Post toEntity(PostDTO postDTO);

}
