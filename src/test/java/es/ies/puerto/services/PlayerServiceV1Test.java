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
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.controller.interfaces.IMobController;
import es.ies.puerto.controller.interfaces.IPlayerController;

class PlayerServiceV1Test {
    @Mock
    IPlayerController iPlayerController;
    PlayerServiceV1 playerServiceV1;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        playerServiceV1 = new PlayerServiceV1();
        playerServiceV1.setIPlayerController(iPlayerController);

    }

    @Test
    void getControllerTest() {
        Assertions.assertEquals(iPlayerController, playerServiceV1.getIPlayerController());
    }

    @Test
    void getAllTest() {
        when(iPlayerController.findAll()).thenReturn(new ArrayList<>());
        List<PlayerDto> biomeDtos = playerServiceV1.getAll();

        Assertions.assertNotNull(biomeDtos);
    }

    @Test
    void getByIDTest() {
        when(iPlayerController.findById(anyInt())).thenReturn(new PlayerDto());
        PlayerDto biomeDto = playerServiceV1.getById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveTest() {
        when(iPlayerController.save(any(PlayerDto.class))).thenReturn(new PlayerDto());
        PlayerDto biomeDto = playerServiceV1.save(new PlayerDto());

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iPlayerController).deleteById(anyInt());
        playerServiceV1.deleteById(1);

        Assertions.assertTrue(true);
    }

}
