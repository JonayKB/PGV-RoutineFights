package es.ies.puerto.routineFights.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.api.mappers.UserMapper;
import es.ies.puerto.routineFights.model.User;
import es.ies.puerto.routineFights.repository.UserRepository;
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Set<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        Set<UserDTO> userDTOs = new HashSet<>();
        for (User user : users) {
            userDTOs.add(UserMapper.INSTANCE.toDto(user));
        }
        return userDTOs;

    }

}
