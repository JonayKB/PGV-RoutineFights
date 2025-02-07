package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
/**
 * PlayerServiceSoapInterface
 */
@WebService()
public interface PlayerServiceSoapInterface {

    /**
     * Get all players
     * 
     * @return list of playerDto
     */
    @WebMethod
    @WebResult(name = "player")
    List<PlayerDto> getAll();

    /**
     * Get a player by id
     * 
     * @param playerId player id
     * @return playerDto
     */
    @WebMethod
    PlayerDto getById(@WebParam(name = "playerId") int playerId);

    /**
     * Delete a player by id
     * 
     * @param playerId player id
     * @return true if the player was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "playerId") int playerId);

    /**
     * Create a player
     * 
     * @param player playerDto
     * @return playerDto
     */
    @WebMethod
    PlayerDto create(@WebParam(name = "player") PlayerDto player);

}