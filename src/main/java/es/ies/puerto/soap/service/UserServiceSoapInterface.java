package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface UserServiceSoapInterface {

    @WebMethod
    @WebResult(name = "user")
    List<UserDto> getAll();

    @WebMethod
    UserDto getById(@WebParam(name = "userId") int userId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "userId") int userId);

    @WebMethod
    UserDto create(@WebParam(name = "user") UserDto user);

}