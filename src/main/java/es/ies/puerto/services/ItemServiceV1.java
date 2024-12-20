package es.ies.puerto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.interfaces.IItemController;
import es.ies.puerto.controller.interfaces.IPlayerController;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/items")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
public class ItemServiceV1 {
    IItemController iItemController;

    public IItemController getIItemController() {
        return this.iItemController;
    }

    @Autowired
    public void setIItemController(IItemController iItemController) {
        this.iItemController = iItemController;
    }

    @GetMapping
    public List<ItemDto> getAll() {
        return iItemController.findAll();
    }

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable(name = "id") final int id) {
        return iItemController.findById(id);
    }

    @PostMapping
    public ItemDto save(@RequestBody ItemDto entity) {
        return iItemController.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iItemController.deleteById(id);
    }

}
