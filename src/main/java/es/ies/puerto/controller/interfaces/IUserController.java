package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.UserDto;
import es.ies.puerto.model.repository.IUserRepository;

public interface IUserController {
    /**
     * Get the IUserRepository
     * 
     * @return IUserRepository
     */
    public IUserRepository getIUserRepository();

    /**
     * Set the IUserRepository
     * 
     * @param userRepository IUserRepository
     */
    public void setIUserRepository(IUserRepository userRepository);

    /**
     * Find all users
     * 
     * @return list of UserDto
     */
    public List<UserDto> findAll();

    /**
     * Find a user by id
     * 
     * @param id user id
     * @return UserDto
     */
    public UserDto findById(Integer id);

    /**
     * Save a user
     * 
     * @param userDto UserDto
     * @return UserDto
     */
    public UserDto save(UserDto userDto);

    /**
     * Delete a user by id
     * 
     * @param id user id
     */
    public void deleteById(Integer id);
}
