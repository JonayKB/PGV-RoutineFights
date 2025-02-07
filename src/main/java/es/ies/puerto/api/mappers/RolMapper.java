package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.model.entity.Rol;
/**
 * RolMapper
 */
@Mapper()
public interface RolMapper {
    RolMapper INSTANCE = Mappers.getMapper(RolMapper.class);

    public RolDto toRolDto(Rol rol);

    public Rol toRol(RolDto rolDto);
}
