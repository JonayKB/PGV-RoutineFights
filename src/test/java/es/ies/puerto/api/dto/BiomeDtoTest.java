package es.ies.puerto.api.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiomeDtoTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    private static final int DIMENSION_ID = 1;
    BiomeDto biomeDto;
    Set<MobDto> spawnMobs;

    @BeforeEach
    void beforeEach() {
        BiomeDto biomeDtoTest = new BiomeDto(null, NAME, spawnMobs, null);
        biomeDto = new BiomeDto();
        spawnMobs = new HashSet<>();
        biomeDto.setDimensionId(DIMENSION_ID);
        biomeDto.setId(ID);
        biomeDto.setName(NAME);
        biomeDto.setSpawnMobs(spawnMobs);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(DIMENSION_ID, biomeDto.getDimensionId());
        Assertions.assertEquals(ID, biomeDto.getId());
        Assertions.assertEquals(NAME, biomeDto.getName());
        Assertions.assertEquals(spawnMobs, biomeDto.getSpawnMobs());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(biomeDto.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), biomeDto.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(biomeDto, biomeDto);
    }

    @Test
    void equalsTrueTest(){
        BiomeDto biomeDtoEquals = new BiomeDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertEquals(biomeDto, biomeDtoEquals);
    }

    @Test
    void equalsFalseTest(){
        BiomeDto biomeDtoEquals = new BiomeDto();
        biomeDtoEquals.setId(2);
        Assertions.assertNotEquals(biomeDto, biomeDtoEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(biomeDto, biomeDtoEquals);
    }
}
