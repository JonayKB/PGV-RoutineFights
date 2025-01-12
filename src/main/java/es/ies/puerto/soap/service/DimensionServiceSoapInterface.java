package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface DimensionServiceSoapInterface {

    @WebMethod
    @WebResult(name = "dimension")
    List<DimensionDto> getAll();

    @WebMethod
    DimensionDto getById(@WebParam(name = "dimensionId") int dimensionId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "dimensionId") int dimensionId);

    @WebMethod
    DimensionDto create(@WebParam(name = "dimension") DimensionDto dimension);

}