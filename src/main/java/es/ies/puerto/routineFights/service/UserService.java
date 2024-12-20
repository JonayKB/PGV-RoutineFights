package es.ies.puerto.routineFights.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.api.mappers.UserMapper;
import es.ies.puerto.routineFights.model.User;
import es.ies.puerto.routineFights.repository.UserRepository;
@Service
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
    public UserDTO findById(int id){
        User user = userRepository.findById(id).orElse(null);
        return UserMapper.INSTANCE.toDto(user);
    }
    public UserDTO save(UserDTO userDTO){
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

}
