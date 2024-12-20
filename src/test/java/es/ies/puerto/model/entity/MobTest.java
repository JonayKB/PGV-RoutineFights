package es.ies.puerto.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.PlayerDto;

class MobTest {
    private static final int BASE_HEALTH = 20;
    private static final int BASE_ATTACK = 10;
    private static final String NAME = "name";
    private static final String ABILITY = "ability";
    private static final int ID = 0;
    Mob mob;
    List<Item> dropList;
    Set<Biome> biomes;

    @BeforeEach
    void beforeEach() {
        Mob biomeTest = new Mob(null, NAME, null, null, ABILITY, dropList);
        mob = new Mob();
        biomes = new HashSet<>();
        dropList = new ArrayList<>();
        mob.setId(ID);
        mob.setName(NAME);
        mob.setBaseAttack(BASE_ATTACK);
        mob.setBaseHealth(BASE_HEALTH);
        mob.setBiomes(biomes);
        mob.setDropList(dropList);
        mob.setSpecialAbility(ABILITY);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, mob.getId());
        Assertions.assertEquals(NAME, mob.getName());
        Assertions.assertEquals(BASE_ATTACK, mob.getBaseAttack());
        Assertions.assertEquals(BASE_HEALTH, mob.getBaseHealth());
        Assertions.assertEquals(biomes, mob.getBiomes());
        Assertions.assertEquals(dropList, mob.getDropList());
        Assertions.assertEquals(ABILITY, mob.getSpecialAbility());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(mob.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), mob.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(mob, mob);
    }

    @Test
    void equalsTrueTest(){
        Mob biomeEquals = new Mob();
        biomeEquals.setId(ID);
        Assertions.assertEquals(mob, biomeEquals);
    }

    @Test
    void equalsFalseTest(){
        Mob biomeEquals = new Mob();
        biomeEquals.setId(2);
        Assertions.assertNotEquals(mob, biomeEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(mob, biomeDtoEquals);
    }
}
