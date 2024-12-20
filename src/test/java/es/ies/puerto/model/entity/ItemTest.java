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

class ItemTest {
    private static final String NAME = "name";
    private static final int ID = 0;
    Item item;
    List<Mob> mobIds;
    List<Player> playerIds;

    @BeforeEach
    void beforeEach() {
        Item biomeDtoTest = new Item(null, NAME);
        item = new Item();
        playerIds = new ArrayList<>();
        mobIds = new ArrayList<>();
        item.setId(ID);
        item.setName(NAME);
        item.setMobs(mobIds);
        item.setPlayers(playerIds);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, item.getId());
        Assertions.assertEquals(NAME, item.getName());
        Assertions.assertEquals(mobIds, item.getMobs());
        Assertions.assertEquals(playerIds, item.getPlayers());

    }

    @Test
    void toStringTest() {
        Assertions.assertTrue(item.toString().contains(NAME));
    }

    @Test
    void hashCodeTest() {
        Assertions.assertEquals(Objects.hash(ID), item.hashCode());
    }

    @Test
    void equalsSelfTest() {
        Assertions.assertEquals(item, item);
    }

    @Test
    void equalsTrueTest() {
        Item biomeEquals = new Item();
        biomeEquals.setId(ID);
        Assertions.assertEquals(item, biomeEquals);
    }

    @Test
    void equalsFalseTest() {
        Item biomeEquals = new Item();
        biomeEquals.setId(2);
        Assertions.assertNotEquals(item, biomeEquals);
    }

    @Test
    void equalsNotBiomeTest() {
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(item, biomeDtoEquals);
    }
}
