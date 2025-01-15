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

    /**
     * Get all items
     * 
     * @return list of itemDto
     */
    @WebMethod
    @WebResult(name = "item")
    List<ItemDto> getAll();

    /**
     * Get an item by id
     * 
     * @param itemId item id
     * @return itemDto
     */
    @WebMethod
    ItemDto getById(@WebParam(name = "itemId") int itemId);

    /**
     * Delete an item by id
     * 
     * @param itemId item id
     * @return true if the item was deleted
     */
    @WebMethod
    Boolean deleteById(@WebParam(name = "itemId") int itemId);

    /**
     * Create an item
     * 
     * @param item itemDto
     * @return itemDto
     */
    @WebMethod
    ItemDto create(@WebParam(name = "item") ItemDto item);

}