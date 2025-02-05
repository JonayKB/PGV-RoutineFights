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

import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.PlayerController;
import es.ies.puerto.soap.service.PlayerServiceSoapImpl;

public class PlayerServiceSoapTest {

    @Mock
    private PlayerController playerController;

    @InjectMocks
    private PlayerServiceSoapImpl playerServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        PlayerDto player1 = new PlayerDto(); 
        PlayerDto player2 = new PlayerDto();
        List<PlayerDto> expectedList = Arrays.asList(player1, player2);
        when(playerController.findAll()).thenReturn(expectedList);

        List<PlayerDto> actualList = playerServiceSoap.getAll();

        assertEquals(expectedList, actualList);
        verify(playerController, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        int testId = 1;
        PlayerDto expectedPlayer = new PlayerDto(); 
        when(playerController.findById(testId)).thenReturn(expectedPlayer);

        PlayerDto actualPlayer = playerServiceSoap.getById(testId);

        assertEquals(expectedPlayer, actualPlayer);
        verify(playerController, times(1)).findById(testId);
    }

    @Test
    public void testDeleteById_Success() {
        int testId = 1;
        doNothing().when(playerController).deleteById(testId);

        Boolean result = playerServiceSoap.deleteById(testId);

        assertTrue(result);
        verify(playerController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {
        int testId = 1;
        doThrow(new RuntimeException("Deletion failed")).when(playerController).deleteById(testId);

        Boolean result = playerServiceSoap.deleteById(testId);

        assertFalse(result);
        verify(playerController, times(1)).deleteById(testId);
    }

    @Test
    public void testCreate() {
        PlayerDto inputPlayer = new PlayerDto(); 
        PlayerDto savedPlayer = new PlayerDto(); 
        when(playerController.save(inputPlayer)).thenReturn(savedPlayer);

        PlayerDto actualPlayer = playerServiceSoap.create(inputPlayer);

        assertEquals(savedPlayer, actualPlayer);
        verify(playerController, times(1)).save(inputPlayer);
    }
}

