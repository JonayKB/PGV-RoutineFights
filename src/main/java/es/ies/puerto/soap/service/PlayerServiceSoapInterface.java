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

@WebService()
public interface PlayerServiceSoapInterface {

    @WebMethod
    @WebResult(name = "player")
    List<PlayerDto> getAll();

    @WebMethod
    PlayerDto getById(@WebParam(name = "playerId") int playerId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "playerId") int playerId);

    @WebMethod
    PlayerDto create(@WebParam(name = "player") PlayerDto player);

}