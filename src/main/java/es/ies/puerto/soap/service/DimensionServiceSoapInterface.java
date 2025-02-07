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
/**
 * BiomeServiceSoapInterface
 */
@WebService()
public interface DimensionServiceSoapInterface {

    /**
     * Get all dimensions
     * 
     * @return list of dimensionDto
     */
    @WebMethod
    @WebResult(name = "dimension")
    List<DimensionDto> getAll();

    /**
     * Get a dimension by id
     * 
     * @param dimensionId dimension id
     * @return dimensionDto
     */
    @WebMethod
    DimensionDto getById(@WebParam(name = "dimensionId") int dimensionId);

    /**
     * Delete a dimension by id
     * 
     * @param dimensionId dimension id
     * @return true if the dimension was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "dimensionId") int dimensionId);

    /**
     * Create a dimension
     * 
     * @param dimension dimensionDto
     * @return dimensionDto
     */
    @WebMethod
    DimensionDto create(@WebParam(name = "dimension") DimensionDto dimension);

}