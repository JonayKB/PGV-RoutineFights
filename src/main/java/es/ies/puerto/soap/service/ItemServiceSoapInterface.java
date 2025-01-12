package es.ies.puerto.soap.service;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.dto.UserDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService()
public interface ItemServiceSoapInterface {

    @WebMethod
    @WebResult(name = "item")
    List<ItemDto> getAll();

    @WebMethod
    ItemDto getById(@WebParam(name = "itemId") int itemId);

    @WebMethod
    Boolean deleteById(@WebParam(name = "itemId") int itemId);

    @WebMethod
    ItemDto create(@WebParam(name = "item") ItemDto item);

}