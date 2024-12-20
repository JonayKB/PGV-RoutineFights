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

class MobControllerTest {
    IMobController iMobController;

    @Mock
    IItemRepository iItemRepository;
    @Mock
    IMobRepository iMobRepository;
    @Mock
    IBiomeRepository iBiomeRepository;


    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        iMobController = new MobController();
        iMobController.setIItemRepository(iItemRepository);
        iMobController.setIMobRepository(iMobRepository);
        iMobController.setIBiomeRepository(iBiomeRepository);

    }

    @Test
    void getRepositoryTest() {
        Assertions.assertNotNull(iMobController.getIItemRepository());
        Assertions.assertNotNull(iMobController.getIMobRepository());
        Assertions.assertNotNull(iMobController.getIBiomeRepository());
    }

    @Test
    void findAllTest() {
        when(iMobRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Mob())));
        List<MobDto> biomeDto = iMobController.findAll();

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdTest() {
        when(iMobRepository.findById(anyInt())).thenReturn(Optional.of(new Mob()));
        MobDto biomeDto = iMobController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdNotPresentTest() {
        when(iItemRepository.findById(anyInt())).thenReturn(Optional.empty());
        MobDto biomeDto = iMobController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveTest() {
        when(iMobRepository.save(any())).thenReturn(new Mob());
        when(iItemRepository.findById(any())).thenReturn(Optional.of(new Item()));
        when(iBiomeRepository.findById(any())).thenReturn(Optional.of(new Biome(1, null, null)));
        MobDto biomeDto = iMobController.save(new MobDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, null, null))), new HashSet<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveNotNullListsTest() {
        when(iMobRepository.save(any())).thenReturn(new Mob());
        Item item = new Item();
        item.setMobs(new ArrayList<>());
        when(iItemRepository.findById(any())).thenReturn(Optional.of(item));
        when(iBiomeRepository.findById(any())).thenReturn(Optional.of(new Biome(1, null, new HashSet<>())));
        MobDto biomeDto = iMobController.save(new MobDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, null, null))), new HashSet<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotPresentTest() {
        when(iMobRepository.save(any())).thenReturn(new Mob());
        when(iItemRepository.findById(any())).thenReturn(Optional.empty());
        when(iBiomeRepository.findById(any())).thenReturn(Optional.empty());
        MobDto biomeDto = iMobController.save(new MobDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, null, null))), new HashSet<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotBiomesTest() {
        when(iMobRepository.save(any())).thenReturn(new Mob());
        when(iItemRepository.findById(any())).thenReturn(Optional.empty());
        when(iBiomeRepository.findById(any())).thenReturn(Optional.empty());
        MobDto biomeDto = iMobController.save(new MobDto(null, null, null, null, null, new ArrayList<>(Arrays.asList(new ItemDto(null, null, null, null))), new HashSet<>(Arrays.asList(1))));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iItemRepository).deleteById(anyInt());
        iMobController.deleteById(1);

        Assertions.assertTrue(true);
    }
}
