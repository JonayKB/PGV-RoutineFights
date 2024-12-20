package es.ies.puerto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.controller.interfaces.IItemController;
import es.ies.puerto.controller.interfaces.IMobController;
import es.ies.puerto.controller.interfaces.IPlayerController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;
import es.ies.puerto.model.repository.IPlayerRepository;
import es.ies.puerto.services.ItemServiceV1;

class PlayerControllerTest {
    IPlayerController iPlayerController;

    @Mock
    IPlayerRepository iPlayerRepository;

    @Mock
    IItemRepository iItemRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        iPlayerController = new PlayerController();
        iPlayerController.setIPlayerRepository(iPlayerRepository);
        iPlayerController.setIItemRepository(iItemRepository);

    }

    @Test
    void getRepositoryTest() {
        Assertions.assertNotNull(iPlayerController.getIItemRepository());
        Assertions.assertNotNull(iPlayerController.getIPlayerRepository());
    }

    @Test
    void findAllTest() {
        when(iPlayerRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Player())));
        List<PlayerDto> biomeDto = iPlayerController.findAll();

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdTest() {
        when(iPlayerRepository.findById(anyInt())).thenReturn(Optional.of(new Player()));
        PlayerDto biomeDto = iPlayerController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdNotPresentTest() {
        when(iPlayerRepository.findById(anyInt())).thenReturn(Optional.empty());
        PlayerDto biomeDto = iPlayerController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveTest() {
        when(iPlayerRepository.save(any())).thenReturn(new Player());
        when(iItemRepository.findById(any())).thenReturn(Optional.of(new Item()));
        PlayerDto biomeDto = iPlayerController.save(new PlayerDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, new ArrayList<>(), new ArrayList<>())))));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveNotNullListsTest() {
        when(iPlayerRepository.save(any())).thenReturn(new Player());
        Item item = new Item();
        when(iItemRepository.findById(any())).thenReturn(Optional.of(item));
        PlayerDto biomeDto = iPlayerController.save(new PlayerDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, new ArrayList<>(), new ArrayList<>())))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotItemsListsTest() {
        when(iPlayerRepository.save(any())).thenReturn(new Player());
        Item item = new Item();
        item.setPlayers(new ArrayList<>());
        when(iItemRepository.findById(any())).thenReturn(Optional.of(item));
        PlayerDto biomeDto = iPlayerController.save(new PlayerDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, new ArrayList<>(), new ArrayList<>())))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotPresentTest() {
        when(iPlayerRepository.save(any())).thenReturn(new Player());
        when(iItemRepository.findById(any())).thenReturn(Optional.empty());
        PlayerDto biomeDto = iPlayerController.save(new PlayerDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, new ArrayList<>(), new ArrayList<>())))));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iItemRepository).deleteById(anyInt());
        iPlayerController.deleteById(1);

        Assertions.assertTrue(true);
    }
}
