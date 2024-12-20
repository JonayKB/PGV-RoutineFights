package es.ies.puerto.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.PlayerDto;

class DimensionTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    Dimension dimension;
    Set<Biome> biomes;

    @BeforeEach
    void beforeEach() {
        Dimension biomeDtoTest = new Dimension(null, NAME, null);
        dimension = new Dimension();
        biomes = new HashSet<>();
        dimension.setId(ID);
        dimension.setName(NAME);
        dimension.setBiomes(biomes);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, dimension.getId());
        Assertions.assertEquals(NAME, dimension.getName());
        Assertions.assertEquals(biomes, dimension.getBiomes());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(dimension.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), dimension.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(dimension, dimension);
    }

    @Test
    void equalsTrueTest(){
        Dimension biomeEquals = new Dimension();
        biomeEquals.setId(ID);
        Assertions.assertEquals(dimension, biomeEquals);
    }

    @Test
    void equalsFalseTest(){
        Dimension biomeEquals = new Dimension();
        biomeEquals.setId(2);
        Assertions.assertNotEquals(dimension, biomeEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(dimension, biomeDtoEquals);
    }
}
