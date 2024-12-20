package es.ies.puerto.api.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerDtoTest {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";
    private static final String NICKNAME = "nick";
    private static final int LEVEL = 10;
    private static final int ID = 0;
    PlayerDto playerDto;
    List<ItemDto> itemDtos;

    @BeforeEach
    void beforeEach() {
        PlayerDto biomeDtoTest = new PlayerDto(null, null, null, null, null, null);
        playerDto = new PlayerDto();
        itemDtos = new ArrayList<>();
        playerDto.setId(ID);
        playerDto.setItems(itemDtos);
        playerDto.setLevel(LEVEL);
        playerDto.setNickname(NICKNAME);
        playerDto.setPassword(PASSWORD);
        playerDto.setUsername(USERNAME);
    }

    @Test
    void gettersSetters() {
        Assertions.assertEquals(ID, playerDto.getId());
        Assertions.assertEquals(itemDtos, playerDto.getItems());
        Assertions.assertEquals(LEVEL, playerDto.getLevel());
        Assertions.assertEquals(NICKNAME, playerDto.getNickname());
        Assertions.assertEquals(PASSWORD, playerDto.getPassword());
        Assertions.assertEquals(USERNAME, playerDto.getUsername());

    }

    @Test
    void toStringTest(){
        Assertions.assertTrue(playerDto.toString().contains(NICKNAME));
    }

    @Test
    void hashCodeTest(){
        Assertions.assertEquals(Objects.hash(ID), playerDto.hashCode());
    }

    @Test
    void equalsSelfTest(){
        Assertions.assertEquals(playerDto, playerDto);
    }

    @Test
    void equalsTrueTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertEquals(playerDto, biomeDtoEquals);
    }

    @Test
    void equalsFalseTest(){
        PlayerDto biomeDtoEquals = new PlayerDto();
        biomeDtoEquals.setId(2);
        Assertions.assertNotEquals(playerDto, biomeDtoEquals);
    }
    @Test
    void equalsNotBiomeTest(){
        DimensionDto biomeDtoEquals = new DimensionDto();
        biomeDtoEquals.setId(ID);
        Assertions.assertNotEquals(playerDto, biomeDtoEquals);
    }
}
