package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.api.mappers.UserMapper;
import es.ies.puerto.controller.interfaces.IUserController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;

import es.ies.puerto.model.repository.IDimensionRepository;
import es.ies.puerto.model.repository.IUserRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import es.ies.puerto.model.entity.User;

/**
 * UserController
 */
@Transactional
@Controller
public class UserController implements IUserController {
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public IUserRepository getIUserRepository() {
        return this.userRepository;
    }

    @Override
    @Autowired
    public void setIUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            userDtos.add(UserMapper.INSTANCE.toUserDto(user));
        }

        return userDtos;
    }

    @Override
    public UserDto findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            return new UserDto();
        }
        UserDto userDto = UserMapper.INSTANCE.toUserDto(userOptional.get());

        return userDto;
    }

    public UserDto findByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            return null;
        }
        UserDto userDto = UserMapper.INSTANCE.toUserDto(userOptional.get());

        return userDto;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserDto userDto2 = UserMapper.INSTANCE.toUserDto(userRepository.save(user));
        return userDto2;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user = UserMapper.INSTANCE.toUser(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return UserMapper.INSTANCE.toUserDto(userRepository.save(user));
    }

}
