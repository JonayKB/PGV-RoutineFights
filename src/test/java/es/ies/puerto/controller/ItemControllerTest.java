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
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.controller.interfaces.IItemController;
import es.ies.puerto.controller.interfaces.IMobController;
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

class ItemControllerTest {
    IItemController iItemController;

    @Mock
    IItemRepository iItemRepository;
    @Mock
    IMobRepository iMobRepository;
    @Mock
    IPlayerRepository iPlayerRepository;


    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        iItemController = new ItemController();
        iItemController.setIItemRepository(iItemRepository);
        iItemController.setIMobRepository(iMobRepository);
        iItemController.setIPlayerRepository(iPlayerRepository);
    }

    @Test
    void getRepositoryTest() {
        Assertions.assertNotNull(iItemController.getIItemRepository());
        Assertions.assertNotNull(iItemController.getIMobRepository());
        Assertions.assertNotNull(iItemController.getIPlayerRepository());
    }

    @Test
    void findAllTest() {
        when(iItemRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Item())));
        List<ItemDto> biomeDto = iItemController.findAll();

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdTest() {
        when(iItemRepository.findById(anyInt())).thenReturn(Optional.of(new Item()));
        ItemDto biomeDto = iItemController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdNotPresentTest() {
        when(iItemRepository.findById(anyInt())).thenReturn(Optional.empty());
        ItemDto biomeDto = iItemController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveTest() {
        when(iItemRepository.save(any())).thenReturn(new Item());
        when(iMobRepository.findById(any())).thenReturn(Optional.of(new Mob()));
        when(iPlayerRepository.findById(any())).thenReturn(Optional.of(new Player()));
        ItemDto biomeDto = iItemController.save(new ItemDto(null, null, new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotPresentTest() {
        when(iItemRepository.save(any())).thenReturn(new Item());
        when(iMobRepository.findById(any())).thenReturn(Optional.empty());
        when(iPlayerRepository.findById(any())).thenReturn(Optional.empty());
        ItemDto biomeDto = iItemController.save(new ItemDto(null, null, new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotBiomesTest() {
        when(iItemRepository.save(any())).thenReturn(new Item());
        when(iMobRepository.findById(any())).thenReturn(Optional.empty());
        ItemDto biomeDto = iItemController.save(new ItemDto(null, null, null, null));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iItemRepository).deleteById(anyInt());
        iItemController.deleteById(1);

        Assertions.assertTrue(true);
    }
}
