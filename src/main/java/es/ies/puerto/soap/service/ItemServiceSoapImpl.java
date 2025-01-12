package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.controller.DimensionController;
import es.ies.puerto.controller.ItemController;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.ItemServiceSoapInterface")
public class ItemServiceSoapImpl implements ItemServiceSoapInterface {
    private ItemController itemController;

    @Autowired
    public void setItemController(ItemController itemController) {
        this.itemController = itemController;
    }

    @Override
    public List<ItemDto> getAll() {
        return itemController.findAll();
    }

    @Override
    public ItemDto getById(int itemId) {
        return itemController.findById(itemId);
    }

    @Override
    public Boolean deleteById(int itemId) {
        try {
            itemController.deleteById(itemId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ItemDto create(ItemDto item) {
        return itemController.save(item);
    }

    
}