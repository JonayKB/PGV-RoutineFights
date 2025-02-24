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
import org.springframework.boot.test.context.SpringBootTest;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.controller.interfaces.IMobController;
import es.ies.puerto.services.v3.MobService;
@SpringBootTest

class MobServiceV1Test {
    @Mock
    IMobController iMobController;
    MobService mobServiceV1;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        mobServiceV1 = new MobService();
        mobServiceV1.setIMobController(iMobController);

    }

    @Test
    void getControllerTest() {
        Assertions.assertEquals(iMobController, mobServiceV1.getIMobController());
    }

    @Test
    void getAllTest() {
        when(iMobController.findAll()).thenReturn(new ArrayList<>());
        List<MobDto> biomeDtos = mobServiceV1.getAll();

        Assertions.assertNotNull(biomeDtos);
    }

    @Test
    void getByIDTest() {
        when(iMobController.findById(anyInt())).thenReturn(new MobDto());
        MobDto biomeDto = mobServiceV1.getById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveTest() {
        when(iMobController.save(any(MobDto.class))).thenReturn(new MobDto());
        MobDto biomeDto = mobServiceV1.save(new MobDto());

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iMobController).deleteById(anyInt());
        mobServiceV1.deleteById(1);

        Assertions.assertTrue(true);
    }
}
