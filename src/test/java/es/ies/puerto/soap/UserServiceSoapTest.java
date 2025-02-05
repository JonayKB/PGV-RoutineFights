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

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.UserController;
import es.ies.puerto.soap.service.UserServiceSoapImpl;

public class UserServiceSoapTest {

    @Mock
    private UserController userController;

    @InjectMocks
    private UserServiceSoapImpl userServiceSoap;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        UserDto user1 = new UserDto();  
        UserDto user2 = new UserDto();
        List<UserDto> expectedList = Arrays.asList(user1, user2);
        when(userController.findAll()).thenReturn(expectedList);

        List<UserDto> actualList = userServiceSoap.getAll();

        assertEquals(expectedList, actualList);
        verify(userController, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        int testId = 1;
        UserDto expectedUser = new UserDto(); 
        when(userController.findById(testId)).thenReturn(expectedUser);

        UserDto actualUser = userServiceSoap.getById(testId);

        assertEquals(expectedUser, actualUser);
        verify(userController, times(1)).findById(testId);
    }

    @Test
    public void testDeleteById_Success() {
        int testId = 1;
        doNothing().when(userController).deleteById(testId);

        Boolean result = userServiceSoap.deleteById(testId);

        assertTrue(result);
        verify(userController, times(1)).deleteById(testId);
    }

    @Test
    public void testDeleteById_Failure() {
        int testId = 1;
        doThrow(new RuntimeException("Deletion failed")).when(userController).deleteById(testId);

        Boolean result = userServiceSoap.deleteById(testId);

        assertFalse(result);
        verify(userController, times(1)).deleteById(testId);
    }

    @Test
    public void testCreate() {
        UserDto inputUser = new UserDto(); 
        UserDto savedUser = new UserDto();    
        when(userController.save(inputUser)).thenReturn(savedUser);

        UserDto actualUser = userServiceSoap.create(inputUser);

        assertEquals(savedUser, actualUser);
        verify(userController, times(1)).save(inputUser);
    }
}

