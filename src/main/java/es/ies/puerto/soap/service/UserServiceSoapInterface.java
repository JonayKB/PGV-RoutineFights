package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

/**
 * UserServiceSoapInterface
 */
@WebService()
public interface UserServiceSoapInterface {

    
    @WebMethod
    @WebResult(name = "user")
    /**
     * Get all users
     * 
     * @return list of userDto
     */
    List<UserDto> getAll();

    /**
     * Get an user by id
     * 
     * @param userId user id
     * @return userDto
     */
    @WebMethod
    UserDto getById(@WebParam(name = "userId") int userId);

    /**
     * Delete an user by id
     * 
     * @param userId user id
     * @return true if the user was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "userId") int userId);

    /**
     * Create an user
     * 
     * @param user userDto
     * @return userDto
     */
    @WebMethod
    UserDto create(@WebParam(name = "user") UserDto user);

}