package es.ies.puerto.api.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DimensionDtoTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    DimensionDto dimensionDto;
    Set<BiomeDto> biomes;

    @BeforeEach
    void beforeEach() {
        DimensionDto biomeDtoTest = new DimensionDto(null, NAME, null);
        dimensionDto = new DimensionDto();
        biomes = new HashSet<>();
        dimensionDto.setId(ID);
        dimensionDto.setName(NAME);
        dimensionDto.setBiomes(biomes);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, dimensionDto.getId());
        Assertions.assertEquals(NAME, dimensionDto.getName());
        Assertions.assertEquals(biomes, dimensionDto.getBiomes());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(dimensionDto.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), dimensionDto.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(dimensionDto, dimensionDto);
    }

    @Test
    void equalsTrueTest(){
        DimensionDto biomeDtoEquals = new DimensionDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertEquals(dimensionDto, biomeDtoEquals);
    }

    @Test
    void equalsFalseTest(){
        DimensionDto biomeDtoEquals = new DimensionDto();
        biomeDtoEquals.setId(2);
        Assertions.assertNotEquals(dimensionDto, biomeDtoEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(dimensionDto, biomeDtoEquals);
    }
}
