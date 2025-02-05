package es.ies.puerto.soap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.controller.ItemController;
import es.ies.puerto.soap.service.ItemServiceSoapImpl;

public class ItemServiceSoapTest {

    @Mock
    private ItemController itemController;

    @InjectMocks
    private ItemServiceSoapImpl itemServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {

        ItemDto item1 = new ItemDto(); 
        ItemDto item2 = new ItemDto();
        List<ItemDto> expectedList = Arrays.asList(item1, item2);
        when(itemController.findAll()).thenReturn(expectedList);


        List<ItemDto> actualList = itemServiceSoap.getAll();


        assertEquals(expectedList, actualList);
        verify(itemController, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        int testId = 1;
        ItemDto expectedItem = new ItemDto(); 
        when(itemController.findById(testId)).thenReturn(expectedItem);

        ItemDto actualItem = itemServiceSoap.getById(testId);

        assertEquals(expectedItem, actualItem);
        verify(itemController, times(1)).findById(testId);
    }

    @Test
    public void testDeleteById_Success() {
        int testId = 1;
        doNothing().when(itemController).deleteById(testId);

        Boolean result = itemServiceSoap.deleteById(testId);

        assertTrue(result);
        verify(itemController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {
        int testId = 1;
        doThrow(new RuntimeException("Deletion failed")).when(itemController).deleteById(testId);

        Boolean result = itemServiceSoap.deleteById(testId);

        assertFalse(result);
        verify(itemController, times(1)).deleteById(testId);
    }

    @Test
    public void testCreate() {
        ItemDto inputItem = new ItemDto(); 
        ItemDto savedItem = new ItemDto();
        when(itemController.save(inputItem)).thenReturn(savedItem);

        ItemDto actualItem = itemServiceSoap.create(inputItem);

        assertEquals(savedItem, actualItem);
        verify(itemController, times(1)).save(inputItem);
    }
}
