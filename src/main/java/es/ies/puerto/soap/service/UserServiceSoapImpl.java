package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.controller.UserController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.UserServiceSoapInterface")
public class UserServiceSoapImpl implements UserServiceSoapInterface {
    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @Override
    public List<UserDto> getAll() {
        return userController.findAll();
    }

    @Override
    public UserDto getById(int userId) {
        return userController.findById(userId);
    }

    @Override
    public Boolean deleteById(int userId) {
        try {
            userController.deleteById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public UserDto create(UserDto user) {
        return userController.save(user);
    }

}
