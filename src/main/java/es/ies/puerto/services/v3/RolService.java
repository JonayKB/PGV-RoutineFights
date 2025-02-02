package es.ies.puerto.services.v3;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v3/roles")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.DELETE })

public class RolService {
    IRolController iRolController;

    /**
     * Get the IRolController
     * 
     * @return IRolController
     */
    public IRolController getIRolController() {
        return this.iRolController;
    }

    /**
     * Set the IRolController
     * 
     * @param iRolController IRolController
     */
    @Autowired
    public void setIUserController(IRolController iRolController) {
        this.iRolController = iRolController;
    }

    /**
     * Find all roles
     * 
     * @return list of RolDto
     */
    @GetMapping
    public List<RolDto> getAll() {
        return iRolController.findAll();
    }

    /**
     * Find a role by id
     * 
     * @param id role id
     * @return RolDto
     */
    @GetMapping("/{id}")
    public RolDto getById(@PathVariable(name = "id") final int id) {
        return iRolController.findById(id);
    }

    /**
     * Save a role
     * 
     * @param entity RolDto
     * @return RolDto
     */
    @PostMapping
    public RolDto save(@RequestBody RolDto entity) {
        return iRolController.save(entity);
    }

    @PutMapping
    public RolDto update(@RequestBody RolDto entity) {
        return iRolController.update(entity);
    }

    /**
     * Delete a role by id
     * 
     * @param id role id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {

        iRolController.deleteById(id);
    }
}
