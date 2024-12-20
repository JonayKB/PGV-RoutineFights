package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.interfaces.IUserController;

import java.util.List;

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
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class UserServiceV1 {
    IUserController iUserController;

    public IUserController getIUserController() {
        return this.iUserController;
    }

    @Autowired
    public void setIUserController(IUserController iUserController) {
        this.iUserController = iUserController;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return iUserController.findAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable(name = "id") final int id) {
        return iUserController.findById(id);
    }

    @PostMapping
    public UserDto save(@RequestBody UserDto entity) {
        return iUserController.save(entity);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iUserController.deleteById(id);
    }
}
