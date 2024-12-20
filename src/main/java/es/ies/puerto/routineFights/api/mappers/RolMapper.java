package es.ies.puerto.routineFights.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.routineFights.api.dto.RolDTO;
import es.ies.puerto.routineFights.model.Rol;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    RolDTO toDto(Rol rol);
    Rol toEntity(RolDTO rolDTO);

}
