package es.ies.puerto.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.PlayerDto;

class BiomeTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    Biome biome;
    Set<Mob> spawnMobs;
    Dimension dimension;

    @BeforeEach
    void beforeEach() {
        dimension = new Dimension();
        Biome biomeDtoTest = new Biome(null, NAME, spawnMobs);
        biome = new Biome();
        spawnMobs = new HashSet<>();
        biome.setDimension(dimension);
        biome.setId(ID);
        biome.setName(NAME);
        biome.setSpawnMobs(spawnMobs);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(dimension, biome.getDimension());
        Assertions.assertEquals(ID, biome.getId());
        Assertions.assertEquals(NAME, biome.getName());
        Assertions.assertEquals(spawnMobs, biome.getSpawnMobs());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(biome.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), biome.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(biome, biome);
    }

    @Test
    void equalsTrueTest(){
        Biome biomeEquals = new Biome();
        biomeEquals.setId(ID);
        Assertions.assertEquals(biome, biomeEquals);
    }

    @Test
    void equalsFalseTest(){
        Biome biomeEquals = new Biome();
        biomeEquals.setId(2);
        Assertions.assertNotEquals(biome, biomeEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(biome, biomeDtoEquals);
    }
}
