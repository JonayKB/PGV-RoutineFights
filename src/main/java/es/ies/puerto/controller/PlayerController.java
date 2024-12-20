package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.api.mappers.PlayerMapper;
import es.ies.puerto.controller.interfaces.IItemController;
import es.ies.puerto.controller.interfaces.IPlayerController;
import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Player;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IPlayerRepository;

@Controller
public class PlayerController implements IPlayerController {
    private IPlayerRepository iPlayerRepository;
    private IItemRepository iItemRepository;

    public IItemRepository getIItemRepository() {
        return this.iItemRepository;
    }

    @Autowired
    public void setIItemRepository(IItemRepository iItemController) {
        this.iItemRepository = iItemController;
    }

    @Override
    public IPlayerRepository getIPlayerRepository() {
        return this.iPlayerRepository;
    }

    @Override
    @Autowired
    public void setIPlayerRepository(IPlayerRepository playerRepository) {
        this.iPlayerRepository = playerRepository;
    }

    @Override
    public List<PlayerDto> findAll() {
        List<PlayerDto> itemDtos = new ArrayList<>();
        List<Player> players = iPlayerRepository.findAll();
        for (Player player : players) {
            itemDtos.add(PlayerMapper.INSTANCE.toPlayerDto(player));
        }
        return itemDtos;
    }

    @Override
    public PlayerDto findById(Integer id) {
        Optional<Player> itemOptional = iPlayerRepository.findById(id);
        if (!itemOptional.isPresent()) {
            return new PlayerDto();
        }
        return PlayerMapper.INSTANCE.toPlayerDto(itemOptional.get());
    }

    @Override
    public PlayerDto save(PlayerDto playerDto) {
        List<Item> items = new ArrayList<>();
        Player player = PlayerMapper.INSTANCE.toPlayer(playerDto);
        for (ItemDto itemDto : playerDto.getItems()) {
            Optional<Item> itemOptional = iItemRepository.findById(itemDto.getId());
            if (itemOptional.isPresent()) {
                Item item = itemOptional.get();
                items.add(item);
                if (item.getPlayers() == null) {
                    item.setPlayers(new ArrayList<>());
                }
                item.getPlayers().add(player);
            }

        }
        player.setItems(items);
        return PlayerMapper.INSTANCE.toPlayerDto(iPlayerRepository.save(player));
    }

    @Override
    public void deleteById(Integer id) {
        iPlayerRepository.deleteById(id);
    }



}
