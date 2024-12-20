package es.ies.puerto.routineFights.api.mappers;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.routineFights.api.dto.ActivityDTO;
import es.ies.puerto.routineFights.api.dto.BadgeDTO;
import es.ies.puerto.routineFights.api.dto.CategoryDTO;
import es.ies.puerto.routineFights.api.dto.CommunityEventDTO;
import es.ies.puerto.routineFights.api.dto.PostDTO;
import es.ies.puerto.routineFights.api.dto.RolDTO;
import es.ies.puerto.routineFights.model.Activity;
import es.ies.puerto.routineFights.model.Badge;
import es.ies.puerto.routineFights.model.Category;
import es.ies.puerto.routineFights.model.CommunityEvent;
import es.ies.puerto.routineFights.model.Post;
import es.ies.puerto.routineFights.model.Rol;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    ActivityDTO toDto(Activity activity);

    Activity toEntity(ActivityDTO activityDTO);

}
