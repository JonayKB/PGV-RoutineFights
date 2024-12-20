package es.ies.puerto.routineFights.api.mappers;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.routineFights.api.dto.CategoryDTO;
import es.ies.puerto.routineFights.api.dto.CommunityEventDTO;
import es.ies.puerto.routineFights.api.dto.PostDTO;
import es.ies.puerto.routineFights.api.dto.RolDTO;
import es.ies.puerto.routineFights.model.Category;
import es.ies.puerto.routineFights.model.CommunityEvent;
import es.ies.puerto.routineFights.model.Post;
import es.ies.puerto.routineFights.model.Rol;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO toDto(Category category);

    Category toEntity(CategoryDTO categoryDTO);

}
