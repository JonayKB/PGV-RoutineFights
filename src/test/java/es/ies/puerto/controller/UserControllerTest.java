package es.ies.puerto.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.test.context.SpringBootTest;

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.UserController;
import es.ies.puerto.model.entity.User;
import es.ies.puerto.model.repository.IUserRepository;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    
    @Mock
    private IUserRepository userRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("john");
        user.setPassword("secret");
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);
        List<UserDto> userDtos = userController.findAll();
        Assertions.assertNotNull(userDtos);
        Assertions.assertEquals(1, userDtos.size());
        Assertions.assertEquals("john", userDtos.get(0).getUsername());
    }
    
    @Test
    void findByIdTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("john");
        user.setPassword("secret");
        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        UserDto userDto = userController.findById(1);
        Assertions.assertNotNull(userDto);
        Assertions.assertEquals("john", userDto.getUsername());
    }
    
    @Test
    void findByIdNotFoundTest() {
        when(userRepository.findById(anyInt())).thenReturn(Optional.empty());
        UserDto userDto = userController.findById(1);
        Assertions.assertNotNull(userDto);
    }
    
    @Test
    void findByUsernameTest() {
        User user = new User();
        user.setId(1);
        user.setUsername("john");
        user.setPassword("secret");
        when(userRepository.findByUsername("john")).thenReturn(Optional.of(user));
        UserDto userDto = userController.findByUsername("john");
        Assertions.assertNotNull(userDto);
        Assertions.assertEquals("john", userDto.getUsername());
    }
    
    @Test
    void findByUsernameNotFoundTest() {
        when(userRepository.findByUsername("john")).thenReturn(Optional.empty());
        UserDto userDto = userController.findByUsername("john");
        Assertions.assertNull(userDto);
    }
    
    @Test
    void saveTest() {
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";
        UserDto inputDto = new UserDto();
        inputDto.setUsername("john");
        inputDto.setPassword(rawPassword);
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);
        User savedUser = new User();
        savedUser.setId(1);
        savedUser.setUsername("john");
        savedUser.setPassword(encodedPassword);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        UserDto savedDto = userController.save(inputDto);
        Assertions.assertNotNull(savedDto);
        Assertions.assertEquals("john", savedDto.getUsername());
        Assertions.assertEquals("HIDDEN", savedDto.getPassword());
    }
    
    @Test
    void updateTest() {
        String rawPassword = "password";
        String encodedPassword = "encodedPassword";
        UserDto inputDto = new UserDto();
        inputDto.setId(1);
        inputDto.setUsername("john");
        inputDto.setPassword(rawPassword);
        when(passwordEncoder.encode(rawPassword)).thenReturn(encodedPassword);
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setUsername("john");
        updatedUser.setPassword(encodedPassword);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);
        UserDto updatedDto = userController.update(inputDto);
        Assertions.assertNotNull(updatedDto);
        Assertions.assertEquals("john", updatedDto.getUsername());
        Assertions.assertEquals(encodedPassword, updatedDto.getPassword());
    }
    
    @Test
    void deleteByIdTest() {
        doNothing().when(userRepository).deleteById(anyInt());
        userController.deleteById(1);
        Assertions.assertTrue(true);
    }
}
