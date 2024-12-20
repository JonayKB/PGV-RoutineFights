package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.model.entity.Biome;

@Mapper(uses = { MobMapper.class })
public interface BiomeMapper {
    BiomeMapper INSTANCE = Mappers.getMapper(BiomeMapper.class);

    @Mapping(source = "dimension.id", target = "dimensionId")
    public BiomeDto toBiomeDto(Biome biome);

    public Biome toBiome(BiomeDto biomeDto);

}
