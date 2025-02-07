package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
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
public interface BiomeServiceSoapInterface {

    /**
     * Get all biomes
     * 
     * @return list of biomeDto
     */
    @WebMethod
    @WebResult(name = "biome")
    List<BiomeDto> getAll();

    /**
     * Get a biome by id
     * 
     * @param biomeId biome id
     * @return biomeDto
     */
    @WebMethod
    BiomeDto getById(@WebParam(name = "biomeId") int biomeId);

    /**
     * Delete a biome by id
     * 
     * @param biomeId biome id
     * @return true if the biome was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "biomeId") int biomeId);

    /**
     * Create a biome
     * 
     * @param biome biomeDto
     * @return biomeDto
     */
    @WebMethod
    BiomeDto create(@WebParam(name = "biome") BiomeDto biome);

}