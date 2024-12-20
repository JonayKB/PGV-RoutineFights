package es.ies.puerto.api.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MobDtoTest {
    private static final int BASE_HEALTH = 20;
    private static final int BASE_ATTACK = 10;
    private static final String NAME = "name";
    private static final String ABILITY = "ability";
    private static final int ID = 0;
    MobDto mobDto;
    List<ItemDto> dropList;
    Set<Integer> biomesIds;

    @BeforeEach
    void beforeEach() {
        MobDto biomeDtoTest = new MobDto(null, ABILITY, null, null, ABILITY, null, null);
        mobDto = new MobDto();
        biomesIds = new HashSet<>();
        dropList = new ArrayList<>();
        mobDto.setId(ID);
        mobDto.setName(NAME);
        mobDto.setBaseAttack(BASE_ATTACK);
        mobDto.setBaseHealth(BASE_HEALTH);
        mobDto.setBiomesIds(biomesIds);
        mobDto.setDropList(dropList);
        mobDto.setSpecialAbility(ABILITY);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, mobDto.getId());
        Assertions.assertEquals(NAME, mobDto.getName());
        Assertions.assertEquals(BASE_ATTACK, mobDto.getBaseAttack());
        Assertions.assertEquals(BASE_HEALTH, mobDto.getBaseHealth());
        Assertions.assertEquals(biomesIds, mobDto.getBiomesIds());
        Assertions.assertEquals(dropList, mobDto.getDropList());
        Assertions.assertEquals(ABILITY, mobDto.getSpecialAbility());
    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(mobDto.toString().contains(NAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), mobDto.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(mobDto, mobDto);
    }

    @Test
    void equalsTrueTest(){
        MobDto biomeDtoEquals = new MobDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertEquals(mobDto, biomeDtoEquals);
    }

    @Test
    void equalsFalseTest(){
        MobDto biomeDtoEquals = new MobDto();
        biomeDtoEquals.setId(2);
        Assertions.assertNotEquals(mobDto, biomeDtoEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(mobDto, biomeDtoEquals);
    }
}
