package es.ies.puerto.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import es.ies.puerto.security.JwtService;

@SpringBootTest
public class JwtServiceTest {
    private static final String ROL = "rol";
    private static final String USER = "user";
    private JwtService  jwtService;

    @BeforeEach
    public void setUp() {
        jwtService = new JwtService();
    }
    @Test
    void generateAndValidateToken() {
        String token = jwtService.generateToken(USER, ROL);

        assert(token != null);
        Map<String, String> claims = jwtService.validateAndGetClaims(token);
        assertEquals(USER, claims.get("username"));
        assertEquals(ROL, claims.get("rol"));

    }   
}
