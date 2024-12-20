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
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;
import es.ies.puerto.services.ItemServiceV1;

class DimensionControllerTest {
    IDimensionController iDimensionController;

    @Mock
    IDimensionRepository iDimensionRepository;
    @Mock
    IBiomeRepository ibBiomeRepository;


    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        iDimensionController = new DimensionController();
        iDimensionController.setIDimensionRepository(iDimensionRepository);
        iDimensionController.setIBiomeRepository(ibBiomeRepository);
    }

    @Test
    void getRepositoryTest() {
        Assertions.assertNotNull(iDimensionController.getIDimensionRepository());
        Assertions.assertNotNull(iDimensionController.getIBiomeRepository());
    }

    @Test
    void findAllTest() {
        when(iDimensionRepository.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Dimension())));
        List<DimensionDto> biomeDto = iDimensionController.findAll();

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdTest() {
        when(iDimensionRepository.findById(anyInt())).thenReturn(Optional.of(new Dimension()));
        DimensionDto biomeDto = iDimensionController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void findByIdNotPresentTest() {
        when(iDimensionRepository.findById(anyInt())).thenReturn(Optional.empty());
        DimensionDto biomeDto = iDimensionController.findById(1);

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveTest() {
        when(iDimensionRepository.save(any())).thenReturn(new Dimension());
        when(ibBiomeRepository.findById(any())).thenReturn(Optional.of(new Biome()));
        DimensionDto biomeDto = iDimensionController.save(new DimensionDto(null, null, new HashSet<>(Arrays.asList(new BiomeDto(1, null, null, null)))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotPresentTest() {
        when(iDimensionRepository.save(any())).thenReturn(new Dimension());
        when(ibBiomeRepository.findById(any())).thenReturn(Optional.empty());
        DimensionDto biomeDto = iDimensionController.save(new DimensionDto(null, null, new HashSet<>(Arrays.asList(new BiomeDto(1, null, null, null)))));

        Assertions.assertNotNull(biomeDto);
    }
    @Test
    void saveNotBiomesTest() {
        when(iDimensionRepository.save(any())).thenReturn(new Dimension());
        when(ibBiomeRepository.findById(any())).thenReturn(Optional.empty());
        DimensionDto biomeDto = iDimensionController.save(new DimensionDto(null, null, null));

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iDimensionRepository).deleteById(anyInt());
        iDimensionController.deleteById(1);

        Assertions.assertTrue(true);
    }
}
