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

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.RolController;
import es.ies.puerto.soap.service.RolServiceSoapImpl;

public class RolServiceSoapTest {

    @Mock
    private RolController rolController;

    @InjectMocks
    private RolServiceSoapImpl rolServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        RolDto inputRol = new RolDto();   
        RolDto savedRol = new RolDto();     
        when(rolController.save(inputRol)).thenReturn(savedRol);

        RolDto result = rolServiceSoap.create(inputRol);

        assertEquals(savedRol, result);
        verify(rolController, times(1)).save(inputRol);
    }

    @Test
    public void testGetById() {
        int testId = 1;
        RolDto expectedRol = new RolDto();   
        when(rolController.findById(testId)).thenReturn(expectedRol);

        RolDto result = rolServiceSoap.getById(testId);

        assertEquals(expectedRol, result);
        verify(rolController, times(1)).findById(testId);
    }

    @Test
    public void testGetAll() {
        RolDto rol1 = new RolDto();
        RolDto rol2 = new RolDto();
        List<RolDto> expectedList = Arrays.asList(rol1, rol2);
        when(rolController.findAll()).thenReturn(expectedList);

        List<RolDto> result = rolServiceSoap.getAll();

        assertEquals(expectedList, result);
        verify(rolController, times(1)).findAll();
    }

    @Test
    public void testDeleteById_Success() {
        int testId = 1;
        doNothing().when(rolController).deleteById(testId);

        Boolean result = rolServiceSoap.deleteById(testId);

        assertTrue(result);
        verify(rolController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {
        int testId = 1;
        doThrow(new RuntimeException("Deletion failed")).when(rolController).deleteById(testId);

        Boolean result = rolServiceSoap.deleteById(testId);

        assertFalse(result);
        verify(rolController, times(1)).deleteById(testId);
    }
}
