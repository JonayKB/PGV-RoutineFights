package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface RolServiceSoapInterface {


    /**
     * Get all roles
     * 
     * @return list of rolDto
     */
    @WebMethod
    @WebResult(name = "rol")
    List<RolDto> getAll();

    /**
     * Get a role by id
     * 
     * @param rolId role id
     * @return rolDto
     */
    @WebMethod
    RolDto getById(@WebParam(name = "rolId") int rolId);

    /**
     * Delete a role by id
     * 
     * @param rolId role id
     * @return true if the role was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "rolId") int rolId);

    /**
     * Create a role
     * 
     * @param rol rolDto
     * @return rolDto
     */
    @WebMethod
    RolDto create(@WebParam(name = "rol") RolDto rol);

}