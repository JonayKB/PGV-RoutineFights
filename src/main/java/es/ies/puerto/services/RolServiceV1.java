package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.interfaces.IRolController;

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
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class RolServiceV1 {
    IRolController iRolController;

    public IRolController getIRolController() {
        return this.iRolController;
    }

    @Autowired
    public void setIUserController(IRolController iRolController) {
        this.iRolController = iRolController;
    }

    @GetMapping
    public List<RolDto> getAll() {
        return iRolController.findAll();
    }

    @GetMapping("/{id}")
    public RolDto getById(@PathVariable(name = "id") final int id) {
        return iRolController.findById(id);
    }

    @PostMapping
    public RolDto save(@RequestBody RolDto entity) {
        return iRolController.save(entity);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iRolController.deleteById(id);
    }
}
