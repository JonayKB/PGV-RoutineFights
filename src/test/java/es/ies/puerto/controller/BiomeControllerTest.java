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
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;
import es.ies.puerto.services.ItemServiceV1;

class BiomeControllerTest {
    IBiomeController iBiomeController;

    @Mock
    IBiomeRepository iBiomeRepository;
    @Mock
    IDimensionRepository iDimensionRepository;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        iBiomeController = new BiomeController();
        iBiomeController.setIBiomeRepository(iBiomeRepository);
        iBiomeController.setIDimensionRepository(iDimensionRepository);
    }

    @Test
    void getRepositoryTest() {
        Assertions.assertNotNull(iBiomeController.getIBiomeRepository());
        Assertions.assertNotNull(iBiomeController.getIDimensionRepository());
    }

    @Test
    void findAllTest() {
        when(iBiomeRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Biome())));
        List<BiomeDto> biomeDto = iBiomeController.findAll();

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdTest() {
        when(iBiomeRepository.findById(anyInt())).thenReturn(Optional.of(new Biome()));
        BiomeDto biomeDto = iBiomeController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdNotPresentTest() {
        when(iBiomeRepository.findById(anyInt())).thenReturn(Optional.empty());
        BiomeDto biomeDto = iBiomeController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveTest() {
        when(iDimensionRepository.findById(anyInt())).thenReturn(Optional.of(new Dimension()));
        when(iBiomeRepository.save(any())).thenReturn(new Biome());
        BiomeDto biomeDtoInsert= new BiomeDto();
        biomeDtoInsert.setDimensionId(1);
        BiomeDto biomeDto = iBiomeController.save(biomeDtoInsert);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotPresentTest() {
        when(iDimensionRepository.findById(anyInt())).thenReturn(Optional.empty());
        BiomeDto biomeDto = iBiomeController.save(new BiomeDto());

        Assertions.assertNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iBiomeRepository).deleteById(anyInt());
        iBiomeController.deleteById(1);

        Assertions.assertTrue(true);
    }
}
