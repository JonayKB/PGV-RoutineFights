package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.model.entity.Item;

@Mapper
public interface ItemMapper extends ItemUtilities {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(source = "item", target = "mobsIds", qualifiedByName = "getMobsIds")
    @Mapping(source = "item", target = "playersIds", qualifiedByName = "getPlayersIds")
    public ItemDto toItemDto(Item item);

    public Item toItem(ItemDto itemDto);

}
