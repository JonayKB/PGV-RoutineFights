package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.model.repository.IUserRepository;

public interface IUserController {
    public IUserRepository getIUserRepository();

    public void setIUserRepository(IUserRepository userRepository);

    public List<UserDto> findAll();

    public UserDto findById(Integer id);

    public UserDto save(UserDto userDto);

    public void deleteById(Integer id);
}
