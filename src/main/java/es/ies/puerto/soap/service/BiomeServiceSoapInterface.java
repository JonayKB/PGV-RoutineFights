package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface BiomeServiceSoapInterface {

    @WebMethod
    @WebResult(name = "biome")
    List<BiomeDto> getAll();

    @WebMethod
    BiomeDto getById(@WebParam(name = "biomeId") int biomeId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "biomeId") int biomeId);

    @WebMethod
    BiomeDto create(@WebParam(name = "biome") BiomeDto biome);

}