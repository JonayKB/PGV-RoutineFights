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
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.controller.interfaces.IItemController;

class ItemServiceV1Test {
    @Mock
    IItemController iItemController;
    ItemServiceV1 ItemServiceV1;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        ItemServiceV1 = new ItemServiceV1();
        ItemServiceV1.setIItemController(iItemController);

    }

    @Test
    void getControllerTest() {
        Assertions.assertEquals(iItemController, ItemServiceV1.getIItemController());
    }

    @Test
    void getAllTest() {
        when(iItemController.findAll()).thenReturn(new ArrayList<>());
        List<ItemDto> biomeDtos = ItemServiceV1.getAll();

        Assertions.assertNotNull(biomeDtos);
    }

    @Test
    void getByIDTest() {
        when(iItemController.findById(anyInt())).thenReturn(new ItemDto());
        ItemDto biomeDto = ItemServiceV1.getById(1);

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void saveTest() {
        when(iItemController.save(any(ItemDto.class))).thenReturn(new ItemDto());
        ItemDto biomeDto = ItemServiceV1.save(new ItemDto());

        Assertions.assertNotNull(biomeDto);
    }

    @Test
    void deleteByIdTest() {
        doNothing().when(iItemController).deleteById(anyInt());
        ItemServiceV1.deleteById(1);

        Assertions.assertTrue(true);
    }
}
