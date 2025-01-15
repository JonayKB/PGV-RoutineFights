package es.ies.puerto.services;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE })
public class UserServiceV1 {
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
        return iUserController.findAll();
    }

    /**
     * Find a user by id
     * 
     * @param id user id
     * @return UserDto
     */
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") final int id) {
        return iUserController.findById(id);
    }

    /**
     * Save a user
     * 
     * @param entity UserDto
     * @return UserDto
     */
    @PostMapping
    public UserDto save(@RequestBody UserDto entity) {
        return iUserController.save(entity);
    }

    /**
     * Delete a user by id
     * 
     * @param id user id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iUserController.deleteById(id);
    }
}
