package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.model.entity.Biome;
/**
 * BiomeMapper
 */
@Mapper(uses = { MobMapper.class })
public interface BiomeMapper {
    /**
     * INSTANCE
     */
    BiomeMapper INSTANCE = Mappers.getMapper(BiomeMapper.class);

    /**
     * toBiomeDto
     * 
     * @param biome Biome
     * @return BiomeDto
     */
    @Mapping(source = "dimension.id", target = "dimensionId")
    public BiomeDto toBiomeDto(Biome biome);

    /**
     * toBiome
     * 
     * @param biomeDto BiomeDto
     * @return Biome
     */
    public Biome toBiome(BiomeDto biomeDto);

}
