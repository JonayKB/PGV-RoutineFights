package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.controller.interfaces.IDimensionController;
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
@RequestMapping("/api/v1/dimensions")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class DimensionServiceV1 {
    IDimensionController iDimensionController;

    /**
     * Get the IDimensionController
     * 
     * @return IDimensionController
     */
    public IDimensionController getIDimensionController() {
        return this.iDimensionController;
    }
    /**
     * Set the IDimensionController
     * 
     * @param iMobController IDimensionController
     */
    @Autowired
    public void setIDimensionController(IDimensionController iMobController) {
        this.iDimensionController = iMobController;
    }

    /**
     * Find all dimensions
     * 
     * @return list of DimensionDto
     */
    @GetMapping
    public List<DimensionDto> getAll() {
        return iDimensionController.findAll();
    }

    /**
     * Find a dimension by id
     * 
     * @param id dimension id
     * @return DimensionDto
     */
    @GetMapping("/{id}")
    public DimensionDto getById(@PathVariable(name = "id") final int id) {
        return iDimensionController.findById(id);
    }

    /**
     * Save a dimension
     * 
     * @param entity DimensionDto
     * @return DimensionDto
     */
    @PostMapping
    public DimensionDto save(@RequestBody DimensionDto entity) {
        return iDimensionController.save(entity);
    }

    /**
     * Delete a dimension by id
     * 
     * @param id dimension id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iDimensionController.deleteById(id);
    }
}
