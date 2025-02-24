package es.ies.puerto.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
/**
 * JwtService
 */
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret = "secret";

    @Value("${jwt.expiration}")
    private long expiration = 9876543210L;

    public String generateToken(String username, String rol) {
        return JWT.create()
                .withSubject(username)
                .withClaim("rol", rol)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(secret));
    }

    public Map<String, String> validateAndGetClaims(String token) {
        Map<String, Claim> claims = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getClaims();

        Map<String, String> infoToken = new HashMap<String, String>();
        infoToken.put("username", claims.get("sub").asString());
        infoToken.put("rol", claims.get("rol").asString());

        return infoToken;
    }
}
