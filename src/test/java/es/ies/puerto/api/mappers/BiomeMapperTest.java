package es.ies.puerto.api.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

class BiomeMapperTest extends MapperUtil {
    @Test
    void toBiome() {
        Biome biomeObtained = BiomeMapper.INSTANCE.toBiome(biomeDto);


        Assertions.assertEquals(biome.getId(), biomeObtained.getId());
        Assertions.assertEquals(biome.getName(), biomeObtained.getName());
        Assertions.assertEquals(biome.getSpawnMobs(), biomeObtained.getSpawnMobs());


        biomeObtained = BiomeMapper.INSTANCE.toBiome(null);

        biomeDto.setDimensionId(null);
        biomeDto.setSpawnMobs(null);

        biomeObtained = BiomeMapper.INSTANCE.toBiome(biomeDto);


    }

    @Test
    void toMobDto() {
        BiomeDto biomeDtoObtained = BiomeMapper.INSTANCE.toBiomeDto(biome);


        Assertions.assertEquals(biomeDto.getId(), biomeDtoObtained.getId());
        Assertions.assertEquals(biomeDto.getName(), biomeDtoObtained.getName());
        Assertions.assertEquals(biomeDto.getDimensionId(), biomeDtoObtained.getDimensionId());
        Assertions.assertEquals(biomeDto.getSpawnMobs(), biomeDtoObtained.getSpawnMobs());


        biomeDtoObtained = BiomeMapper.INSTANCE.toBiomeDto(null);

        biome.setDimension(null);
        biome.setSpawnMobs(null);

        biomeDtoObtained = BiomeMapper.INSTANCE.toBiomeDto(biome);


    }
}
