package es.ies.puerto.soap;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.controller.MobController;
import es.ies.puerto.soap.service.MobServiceSoapImpl;

public class MobServiceSoapTest {

    @Mock
    private MobController mobController;

    @InjectMocks
    private MobServiceSoapImpl mobServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        MobDto mob1 = new MobDto(); 
        MobDto mob2 = new MobDto();
        List<MobDto> expectedList = Arrays.asList(mob1, mob2);
        when(mobController.findAll()).thenReturn(expectedList);
        List<MobDto> actualList = mobServiceSoap.getAll();

        assertEquals(expectedList, actualList);
        verify(mobController, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        int testId = 1;
        MobDto expectedMob = new MobDto(); 
        when(mobController.findById(testId)).thenReturn(expectedMob);

        MobDto actualMob = mobServiceSoap.getById(testId);

        assertEquals(expectedMob, actualMob);
        verify(mobController, times(1)).findById(testId);
    }

    @Test
    public void testDeleteById_Success() {
        int testId = 1;
        doNothing().when(mobController).deleteById(testId);

        Boolean result = mobServiceSoap.deleteById(testId);

        assertTrue(result);
        verify(mobController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {
        int testId = 1;
        doThrow(new RuntimeException("Deletion error")).when(mobController).deleteById(testId);

        Boolean result = mobServiceSoap.deleteById(testId);

        assertFalse(result);
        verify(mobController, times(1)).deleteById(testId);
    }

    @Test
    public void testCreate() {
        MobDto inputMob = new MobDto(); 
        MobDto savedMob = new MobDto(); 
        when(mobController.save(inputMob)).thenReturn(savedMob);

        MobDto actualMob = mobServiceSoap.create(inputMob);

        assertEquals(savedMob, actualMob);
        verify(mobController, times(1)).save(inputMob);
    }
}
