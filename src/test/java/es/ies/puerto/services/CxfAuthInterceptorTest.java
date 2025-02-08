package es.ies.puerto.services;

import org.apache.cxf.message.Message;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.auth0.jwt.exceptions.JWTVerificationException;

import es.ies.puerto.security.CxfAuthInterceptor;
import es.ies.puerto.security.JwtService;

@SpringBootTest
public class CxfAuthInterceptorTest {

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private CxfAuthInterceptor interceptor;

    private Message message;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        message = mock(Message.class);
        SecurityContextHolder.clearContext();
    }

    @Test
    public void testHandleMessage_validTokenWithAdminRole() {
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Authorization", Collections.singletonList("Bearer validToken"));
        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);

        Map<String, String> claims = new HashMap<>();
        claims.put("username", "adminUser");
        claims.put("rol", "ROLE_ADMIN");
        when(jwtService.validateAndGetClaims("validToken")).thenReturn(claims);

        interceptor.handleMessage(message);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        assertNotNull(auth);
        assertEquals("adminUser", auth.getName());
        assertTrue(auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN")));
    }

    @Test()
    public void testHandleMessage_invalidRole() {
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Authorization", Collections.singletonList("Bearer validToken"));
        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);

        Map<String, String> claims = new HashMap<>();
        claims.put("username", "normalUser");
        claims.put("rol", "ROLE_USER");
        when(jwtService.validateAndGetClaims("validToken")).thenReturn(claims);

        assertThrows(SecurityException.class,()->interceptor.handleMessage(message));

    }

    @Test()
    public void testHandleMessage_missingAuthorizationHeader() {
        Map<String, List<String>> headers = new HashMap<>();
        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);

        assertThrows(SecurityException.class,()->interceptor.handleMessage(message));

    }

    @Test()
    public void testHandleMessage_invalidToken() {
        Map<String, List<String>> headers = new HashMap<>();
        headers.put("Authorization", Collections.singletonList("Bearer invalidToken"));
        when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(headers);

        when(jwtService.validateAndGetClaims("invalidToken"))
            .thenThrow(new JWTVerificationException("Invalid token"));

        assertThrows(SecurityException.class,()->interceptor.handleMessage(message));
    }
}

