package es.ies.puerto.services.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.UserController;
import es.ies.puerto.model.entity.User;
import es.ies.puerto.security.JwtService;
import es.ies.puerto.services.v3.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")


public class AuthService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserController userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            UserDto response = userService.findByUsername(user.getUsername());
            if (passwordEncoder.matches(user.getPassword(), response.getPassword())) {
                try {
                    return ResponseEntity
                            .ok(jwtService.generateToken(response.getUsername(), response.getRol().getName()));
                } catch (Exception e) {
                    return ResponseEntity.status(400).body(e.getMessage());
                }
            }
        }
        return ResponseEntity.status(401).build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        if (userService.findByUsername(user.getUsername()) == null) {
            UserDto newUser = new UserDto();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());
            newUser.setRol(new RolDto(5, "user"));
            UserDto response = userService.save(newUser);
            try {
                return ResponseEntity.ok(jwtService.generateToken(response.getUsername(), response.getRol().getName()));
            } catch (Exception e) {
                return ResponseEntity.status(400).body(e.getMessage());

            }
        }
        return ResponseEntity.status(401).build();

    }

}
