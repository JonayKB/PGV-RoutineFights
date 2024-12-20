package es.ies.puerto.routineFights.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.api.mappers.UserMapper;
import es.ies.puerto.routineFights.model.User;
import es.ies.puerto.routineFights.repository.UserRepository;
import es.ies.puerto.routineFights.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<Set<UserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

}
