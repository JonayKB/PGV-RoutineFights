package es.ies.puerto.soap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.controller.DimensionController;
import es.ies.puerto.soap.service.DimensionServiceSoapImpl;

public class DimensionServiceSoapTest {
    @Mock
    private DimensionController dimensionController;

    @InjectMocks
    private DimensionServiceSoapImpl dimensionServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {

        DimensionDto dto1 = new DimensionDto(); 
        DimensionDto dto2 = new DimensionDto();
        List<DimensionDto> expectedList = Arrays.asList(dto1, dto2);
        when(dimensionController.findAll()).thenReturn(expectedList);

        List<DimensionDto> actualList = dimensionServiceSoap.getAll();


        assertEquals(expectedList, actualList);
        verify(dimensionController, times(1)).findAll();
    }

    @Test
    public void testGetById() {

        int testId = 1;
        DimensionDto expectedDto = new DimensionDto(); 
        when(dimensionController.findById(testId)).thenReturn(expectedDto);

        DimensionDto actualDto = dimensionServiceSoap.getById(testId);

        assertEquals(expectedDto, actualDto);
        verify(dimensionController, times(1)).findById(testId);
    }

    @Test
    public void testDeleteById_Success() {

        int testId = 1;
       
        doNothing().when(dimensionController).deleteById(testId);


        Boolean result = dimensionServiceSoap.deleteById(testId);


        assertTrue(result);
        verify(dimensionController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {

        int testId = 1;
        doThrow(new RuntimeException("Delete error")).when(dimensionController).deleteById(testId);


        Boolean result = dimensionServiceSoap.deleteById(testId);


        assertFalse(result);
        verify(dimensionController, times(1)).deleteById(testId);
    }

    @Test
    public void testCreate() {

        DimensionDto inputDto = new DimensionDto();
        DimensionDto expectedDto = new DimensionDto();
        when(dimensionController.save(inputDto)).thenReturn(expectedDto);


        DimensionDto actualDto = dimensionServiceSoap.create(inputDto);


        assertEquals(expectedDto, actualDto);
        verify(dimensionController, times(1)).save(inputDto);
    }
}
