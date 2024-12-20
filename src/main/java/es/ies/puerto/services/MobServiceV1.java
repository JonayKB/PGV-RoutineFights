package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
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
@RequestMapping("mob")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class MobServiceV1 {
    IMobController iMobController;

    public IMobController getIMobController() {
        return this.iMobController;
    }

    @Autowired
    public void setIMobController(IMobController iMobController) {
        this.iMobController = iMobController;
    }

    @GetMapping("/")
    public List<MobDto> getAll() {
        return iMobController.findAll();
    }

    @GetMapping("/{id}")
    public MobDto getById(@PathVariable(name = "id") final int id) {
        return iMobController.findById(id);
    }

    @PostMapping("/")
    public MobDto save(@RequestBody MobDto entity) {
        return iMobController.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iMobController.deleteById(id);
    }
}
