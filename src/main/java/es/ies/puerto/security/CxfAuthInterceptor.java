package es.ies.puerto.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.auth0.jwt.exceptions.JWTVerificationException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

public class CxfAuthInterceptor extends AbstractPhaseInterceptor<Message> {

    @Autowired
    private JwtService jwtSerivce;

    /**
     * Indica la fase en la que ejecuta el interceptor
     */
    public static final String authHeaderTokenPrefix = "Bearer ";

    public CxfAuthInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Map<String, List<String>> protocolHeaders = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);

        if (protocolHeaders != null && protocolHeaders.containsKey("Authorization")) {
            List<String> authorizationHeaders = protocolHeaders.get("Authorization");

            if (authorizationHeaders != null && !authorizationHeaders.isEmpty()) {
                String authorizationHeader = authorizationHeaders.get(0);
                String token = authorizationHeader.substring(authHeaderTokenPrefix.length());
                try {
                    Map<String, String> mapInfoToken = jwtSerivce.validateAndGetClaims(token);
                    final String username = mapInfoToken.get("username");
                    final String rol = mapInfoToken.get("rol");
                    if (rol != "ROLE_ADMIN") {
                        throw new SecurityException("No tienes permisos para acceder a este recurso");
                    }
                    UserDetails userDetails = new UserDetails() {

                        @Override
                        public Collection<? extends GrantedAuthority> getAuthorities() {
                            List<GrantedAuthority> authorities = new ArrayList<>();
                            authorities.add(new SimpleGrantedAuthority(rol));
                            return authorities;
                        }

                        @Override
                        public String getPassword() {
                            return null;
                        }

                        @Override
                        public String getUsername() {
                            return username;
                        }

                    };

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authToken);

                } catch (JWTVerificationException e) {
                    throw new SecurityException("Token no válido");
                }
            }
        } else {
            throw new SecurityException("No se han incluido cabeceras de seguridad");
        }
    }
}