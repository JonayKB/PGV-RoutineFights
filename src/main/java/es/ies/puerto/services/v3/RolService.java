package es.ies.puerto.services.v3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.interfaces.IRolController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(iRolController.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
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
    public ResponseEntity<?> save(@RequestBody RolDto entity) {
        try {
            return ResponseEntity.ok(iRolController.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody RolDto entity) {
        try {
            return ResponseEntity.ok(iRolController.update(entity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    /**
     * Delete a role by id
     * 
     * @param id role id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") final int id) {
        try {
            iRolController.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
