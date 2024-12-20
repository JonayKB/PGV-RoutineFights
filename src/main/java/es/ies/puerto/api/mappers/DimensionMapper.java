package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.model.entity.Dimension;

@Mapper(uses = { BiomeMapper.class })
public interface DimensionMapper {
    DimensionMapper INSTANCE = Mappers.getMapper(DimensionMapper.class);

    public DimensionDto toDimensionDto(Dimension dimension);

    public Dimension toDimension(DimensionDto dimensionDto);
}
