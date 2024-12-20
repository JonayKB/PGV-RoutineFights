package es.ies.puerto.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Player;

@Mapper(uses = { ItemMapper.class })
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    public PlayerDto toPlayerDto(Player player);

    public Player toPlayer(PlayerDto playerDto);
}
