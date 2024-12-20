package es.ies.puerto.api.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

class DimensionMapperTest extends MapperUtil {
    @Test
    void toDimension() {
        Dimension dimensionObtained = DimensionMapper.INSTANCE.toDimension(dimensionDto);


        Assertions.assertEquals(dimension.getId(), dimensionObtained.getId());
        Assertions.assertEquals(dimension.getName(), dimensionObtained.getName());
        Assertions.assertEquals(dimension.getBiomes(), dimensionObtained.getBiomes());


        dimensionObtained = DimensionMapper.INSTANCE.toDimension(null);

        dimensionDto.setBiomes(null);

        dimensionObtained = DimensionMapper.INSTANCE.toDimension(dimensionDto);


    }

    @Test
    void toDimensionDto() {
        DimensionDto dimensionDtoObtained = DimensionMapper.INSTANCE.toDimensionDto(dimension);


        Assertions.assertEquals(dimension.getId(), dimensionDtoObtained.getId());
        Assertions.assertEquals(dimension.getName(), dimensionDtoObtained.getName());
        //Assertions.assertEquals(dimension.getBiomes(), dimensionDtoObtained.getBiomes());


        dimensionDtoObtained = DimensionMapper.INSTANCE.toDimensionDto(null);

        dimensionDto.setBiomes(null);

        dimensionDtoObtained = DimensionMapper.INSTANCE.toDimensionDto(dimension);


    }
}
