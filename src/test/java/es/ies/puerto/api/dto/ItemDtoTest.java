package es.ies.puerto.api.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemDtoTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    ItemDto itemDto;
    List<Integer> mobIds;
    List<Integer> playerIds;

    @BeforeEach
    void beforeEach() {
        ItemDto biomeDtoTest = new ItemDto(null, NAME, playerIds, mobIds);
        itemDto = new ItemDto();
        playerIds = new ArrayList<>();
        mobIds = new ArrayList<>();
        itemDto.setId(ID);
        itemDto.setName(NAME);
        itemDto.setMobsIds(mobIds);
        itemDto.setPlayersIds(playerIds);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, itemDto.getId());
        Assertions.assertEquals(NAME, itemDto.getName());
        Assertions.assertEquals(mobIds, itemDto.getMobsIds());
        Assertions.assertEquals(playerIds, itemDto.getPlayersIds());

    }

    @Test
    void toStringTest() {
        Assertions.assertTrue(itemDto.toString().contains(NAME));
    }

    @Test
    void hashCodeTest() {
        Assertions.assertEquals(Objects.hash(ID), itemDto.hashCode());
    }

    @Test
    void equalsSelfTest() {
        Assertions.assertEquals(itemDto, itemDto);
    }

    @Test
    void equalsTrueTest() {
        ItemDto biomeDtoEquals = new ItemDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertEquals(itemDto, biomeDtoEquals);
    }

    @Test
    void equalsFalseTest() {
        ItemDto biomeDtoEquals = new ItemDto();
        biomeDtoEquals.setId(2);
        Assertions.assertNotEquals(itemDto, biomeDtoEquals);
    }

    @Test
    void equalsNotBiomeTest() {
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(itemDto, biomeDtoEquals);
    }
}
