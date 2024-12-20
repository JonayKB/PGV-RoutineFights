package es.ies.puerto.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.controller.interfaces.IBiomeController;

class BiomeServiceV1Test {
    @Mock
    IBiomeController iBiomeController;
    BiomeServiceV1 biomeServiceV1;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        biomeServiceV1 = new BiomeServiceV1();
        biomeServiceV1.setIIBiomeController(iBiomeController);

    }

    @Test
    void getControllerTest() {
        Assertions.assertEquals(iBiomeController, biomeServiceV1.getIBiomeController());
    }

    @Test
    void getAllTest() {
        when(iBiomeController.findAll()).thenReturn(new ArrayList<>());
        List<BiomeDto> biomeDtos = biomeServiceV1.getAll();

        Assertions.assertNotNull(biomeDtos);
    }

    @Test
    void getByIDTest() {
        when(iBiomeController.findById(anyInt())).thenReturn(new BiomeDto());
        BiomeDto biomeDto = biomeServiceV1.getById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveTest() {
        when(iBiomeController.save(any(BiomeDto.class))).thenReturn(new BiomeDto());
        BiomeDto biomeDto = biomeServiceV1.save(new BiomeDto());

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iBiomeController).deleteById(anyInt());
        biomeServiceV1.deleteById(1);

        Assertions.assertTrue(true);
    }
}
