package es.ies.puerto.api.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

class ItemMapperTest extends MapperUtil {
    @Test
    void toItem() {
        Item itemObtained = ItemMapper.INSTANCE.toItem(itemDto);


        Assertions.assertEquals(item.getId(), itemObtained.getId());
        Assertions.assertEquals(item.getName(), itemObtained.getName());


        itemObtained = ItemMapper.INSTANCE.toItem(null);

        itemDto.setMobsIds(null);
        itemDto.setPlayersIds(null);

        itemObtained = ItemMapper.INSTANCE.toItem(itemDto);


    }

    @Test
    void toItemDto() {
        ItemDto itemDtoObtained = ItemMapper.INSTANCE.toItemDto(item);


        Assertions.assertEquals(itemDto.getId(), itemDtoObtained.getId());
        Assertions.assertEquals(itemDto.getName(), itemDtoObtained.getName());
        Assertions.assertEquals(itemDto.getMobsIds(), itemDtoObtained.getMobsIds());
        Assertions.assertEquals(itemDto.getPlayersIds(), itemDtoObtained.getPlayersIds());


        itemDtoObtained = ItemMapper.INSTANCE.toItemDto(null);

        item.setMobs(null);
        item.setPlayers(null);

        itemDtoObtained = ItemMapper.INSTANCE.toItemDto(item);


    }
}
