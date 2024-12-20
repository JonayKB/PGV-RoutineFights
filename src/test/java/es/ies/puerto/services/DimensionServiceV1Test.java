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
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;

class DimensionServiceV1Test {
    @Mock
    IDimensionController iDimensionController;
    DimensionServiceV1 dimensionServiceV1;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        dimensionServiceV1 = new DimensionServiceV1();
        dimensionServiceV1.setIDimensionController(iDimensionController);

    }

    @Test
    void getControllerTest() {
        Assertions.assertEquals(iDimensionController, dimensionServiceV1.getIDimensionController());
    }

    @Test
    void getAllTest() {
        when(iDimensionController.findAll()).thenReturn(new ArrayList<>());
        List<DimensionDto> biomeDtos = dimensionServiceV1.getAll();

        Assertions.assertNotNull(biomeDtos);
    }

    @Test
    void getByIDTest() {
        when(iDimensionController.findById(anyInt())).thenReturn(new DimensionDto());
        DimensionDto biomeDto = dimensionServiceV1.getById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveTest() {
        when(iDimensionController.save(any(DimensionDto.class))).thenReturn(new DimensionDto());
        DimensionDto biomeDto = dimensionServiceV1.save(new DimensionDto());

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iDimensionController).deleteById(anyInt());
        dimensionServiceV1.deleteById(1);

        Assertions.assertTrue(true);
    }
}
