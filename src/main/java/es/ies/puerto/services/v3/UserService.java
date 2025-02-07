package es.ies.puerto.services.v3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.interfaces.IUserController;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * UserService
 */
@RestController("UserServiceV3")
@RequestMapping("/api/v3/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE })
public class UserService {
    IUserController iUserController;

    /**
     * Get the IUserController
     * 
     * @return IUserController
     */
    public IUserController getIUserController() {
        return this.iUserController;
    }

    /**
     * Set the IUserController
     * 
     * @param iUserController IUserController
     */
    @Autowired
    public void setIUserController(IUserController iUserController) {
        this.iUserController = iUserController;
    }

    /**
     * Find all users
     * 
     * @return list of UserDto
     */
    @GetMapping
    public List<UserDto> getAll() {
        return iUserController.findAll().stream().map(user -> {
            user.setPassword("HIDDEN");
            return user;
        }).toList();
    }

    /**
     * Find a user by id
     * 
     * @param id user id
     * @return UserDto
     */
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") final int id) {
        UserDto user = iUserController.findById(id);
        user.setPassword("HIDDEN");
        return user;
    }

    /**
     * Save a user
     * 
     * @param entity UserDto
     * @return UserDto
     */
    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDto entity) {
        try {
            return ResponseEntity.ok(iUserController.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    /**
     * Update a user
     * 
     * @param entity UserDto
     * @return UserDto
     */
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto entity) {
        try {
            return ResponseEntity.ok(iUserController.update(entity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    /**
     * Delete a user by id
     * 
     * @param id user id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") final int id) {
        try {
            iUserController.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
