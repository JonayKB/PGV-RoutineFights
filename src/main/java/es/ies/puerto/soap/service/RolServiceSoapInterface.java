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

    @WebMethod
    @WebResult(name = "rol")
    List<RolDto> getAll();

    @WebMethod
    RolDto getById(@WebParam(name = "rolId") int rolId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "rolId") int rolId);

    @WebMethod
    RolDto create(@WebParam(name = "rol") RolDto rol);

}