package es.ies.puerto.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.DimensionDto;

class PlayerTest {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";
    private static final String NICKNAME = "nick";
    private static final int LEVEL = 10;
    private static final int ID = 0;
    Player player;
    List<Item> items;

    @BeforeEach
    void beforeEach() {
        Player biomeDtoTest = new Player(null, null, null, null, null, null);
        player = new Player();
        items = new ArrayList<>();
        player.setId(ID);
        player.setItems(items);
        player.setLevel(LEVEL);
        player.setNickname(NICKNAME);
        player.setPassword(PASSWORD);
        player.setUsername(USERNAME);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, player.getId());
        Assertions.assertEquals(items, player.getItems());
        Assertions.assertEquals(LEVEL, player.getLevel());
        Assertions.assertEquals(NICKNAME, player.getNickname());
        Assertions.assertEquals(PASSWORD, player.getPassword());
        Assertions.assertEquals(USERNAME, player.getUsername());

    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(player.toString().contains(NICKNAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), player.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(player, player);
    }

    @Test
    void equalsTrueTest(){
        Player biomeEquals = new Player();
        biomeEquals.setId(ID);
        Assertions.assertEquals(player, biomeEquals);
    }

    @Test
    void equalsFalseTest(){
        Player biomeEquals = new Player();
        biomeEquals.setId(2);
        Assertions.assertNotEquals(player, biomeEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        DimensionDto biomeDtoEquals = new DimensionDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(player, biomeDtoEquals);
    }
}
