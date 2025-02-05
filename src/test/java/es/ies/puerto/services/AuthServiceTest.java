package es.ies.puerto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.crypto.password.PasswordEncoder;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.UserController;
import es.ies.puerto.model.entity.User;
import es.ies.puerto.security.JwtService;
import es.ies.puerto.services.v1.AuthService;

@SpringBootTest
public class AuthServiceTest {
    @Mock
    private JwtService jwtService;

    @Mock
    private UserController userService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void loginTestError() {
        when(userService.findByUsername("user")).thenReturn(null);
        UserDto user = new UserDto();
        user.setUsername("user");
        assert (authService.login(user).getStatusCode() == HttpStatusCode.valueOf(401));
    }

    @Test
    void loginTestOK() {
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        UserDto userDB = new UserDto();
        userDB.setUsername("user");
        userDB.setPassword("password");
        userDB.setRol(new RolDto(5, "ROLE_USER"));
        when(userService.findByUsername("user")).thenReturn(userDB);
        when(passwordEncoder.matches("password", "password")).thenReturn(true);
        assertEquals(authService.login(user).getStatusCode(), HttpStatusCode.valueOf(200));
    }
    @Test
    void loginTestErrorGetRol() {
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        UserDto userDB = new UserDto();
        userDB.setUsername("user");
        userDB.setPassword("password");
        when(userService.findByUsername("user")).thenReturn(userDB);
        when(passwordEncoder.matches("password", "password")).thenReturn(true);
        assertEquals(authService.login(user).getStatusCode(), HttpStatusCode.valueOf(400));
    }
    

    @Test
    void loginTestErrorNotUser(){
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        when(userService.findByUsername("user")).thenReturn(null);
        assertEquals(authService.login(user).getStatusCode(), HttpStatusCode.valueOf(401));
    }
    @Test
    void loginTestErrorInvalidPassword(){
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        UserDto userDB = new UserDto();
        userDB.setUsername("user");
        userDB.setPassword("password");
        when(userService.findByUsername("user")).thenReturn(userDB);
        when(passwordEncoder.matches("password", "password")).thenReturn(false);
        assertEquals(authService.login(user).getStatusCode(), HttpStatusCode.valueOf(401));
    }

    @Test
    void registerTestError() {
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        when(userService.findByUsername("user")).thenReturn(new UserDto());
        assertEquals(authService.register(user).getStatusCode(), HttpStatusCode.valueOf(401));
    }

    

    @Test
    void registerTestErrorGetRol() {
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        when(userService.findByUsername("user")).thenReturn(null);
        when(userService.save(user)).thenReturn(new UserDto());
        assertEquals(authService.register(user).getStatusCode(), HttpStatusCode.valueOf(400));
    }

    @Test
    void registerTestOk() {
        UserDto user = new UserDto();
        user.setUsername("user");
        user.setPassword("password");
        user.setRol(new RolDto(5, "ROLE_USER"));
        when(userService.findByUsername("user")).thenReturn(null);
        when(userService.save(user)).thenReturn(user);
        assertEquals(authService.register(user).getStatusCode(), HttpStatusCode.valueOf(200));
    }
}
