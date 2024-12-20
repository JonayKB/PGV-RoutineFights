package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IMobController;
import es.ies.puerto.controller.interfaces.IPlayerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/biome")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
public class BiomeServiceV1 {
    IBiomeController iBiomeController;

    public IBiomeController getIBiomeController() {
        return this.iBiomeController;
    }

    @Autowired
    public void setIIBiomeController(IBiomeController iMobController) {
        this.iBiomeController = iMobController;
    }

    @GetMapping("/")
    public List<BiomeDto> getAll() {
        return iBiomeController.findAll();
    }

    @GetMapping("/{id}")
    public BiomeDto getById(@PathVariable(name = "id") final int id) {
        return iBiomeController.findById(id);
    }

    @PostMapping("/")
    public BiomeDto save(@RequestBody BiomeDto entity) {
        return iBiomeController.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iBiomeController.deleteById(id);
    }
}
