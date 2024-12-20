package es.ies.puerto.api.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Player;

class PlayerMapperTest extends MapperUtil {
    @Test
    void toPlayer() {
        Player playerObtained = PlayerMapper.INSTANCE.toPlayer(playerDto);


        Assertions.assertEquals(player.getId(), playerObtained.getId());
        Assertions.assertEquals(player.getLevel(), playerObtained.getLevel());
        Assertions.assertEquals(player.getNickname(), playerObtained.getNickname());
        Assertions.assertEquals(player.getPassword(), playerObtained.getPassword());
        Assertions.assertEquals(player.getUsername(), playerObtained.getUsername());
        Assertions.assertEquals(player.getItems(), playerObtained.getItems());

        playerObtained = PlayerMapper.INSTANCE.toPlayer(null);

        playerDto.setItems(null);

        playerObtained = PlayerMapper.INSTANCE.toPlayer(playerDto);


    }

    @Test
    void toPlayerDto() {
        PlayerDto playerDtoObtained = PlayerMapper.INSTANCE.toPlayerDto(player);

        Assertions.assertEquals(playerDto.getId(), playerDtoObtained.getId());
        Assertions.assertEquals(playerDto.getLevel(), playerDtoObtained.getLevel());
        Assertions.assertEquals(playerDto.getNickname(), playerDtoObtained.getNickname());
        Assertions.assertEquals(playerDto.getPassword(), playerDtoObtained.getPassword());
        Assertions.assertEquals(playerDto.getUsername(), playerDtoObtained.getUsername());
        Assertions.assertEquals(playerDto.getItems(), playerDtoObtained.getItems());

        playerDtoObtained = PlayerMapper.INSTANCE.toPlayerDto(null);

        player.setItems(null);
        
        playerDtoObtained = PlayerMapper.INSTANCE.toPlayerDto(player);


    }
}
