package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface MobServiceSoapInterface {

    /**
     * Get all mobs
     * 
     * @return list of mobDto
     */
    @WebMethod
    @WebResult(name = "mob")
    List<MobDto> getAll();

    /**
     * Get a mob by id
     * 
     * @param mobId mob id
     * @return mobDto
     */
    @WebMethod
    MobDto getById(@WebParam(name = "mobId") int mobId);

    /**
     * Delete a mob by id
     * 
     * @param mobId mob id
     * @return true if the mob was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "mobId") int mobId);

    /**
     * Create a mob
     * 
     * @param mob mobDto
     * @return mobDto
     */
    @WebMethod
    MobDto create(@WebParam(name = "mob") MobDto mob);

}