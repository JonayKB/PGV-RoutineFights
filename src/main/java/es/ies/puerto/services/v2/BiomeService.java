package es.ies.puerto.services.v2;

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

import org.apache.cxf.security.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * BiomeService
 */
@RestController("BiomeServiceV2")
@RequestMapping("/api/v2/biomes")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})
public class BiomeService {
    IBiomeController iBiomeController;

    /**
     * Get the IBiomeController
     * 
     * @return IBiomeController
     */
    public IBiomeController getIBiomeController() {
        return this.iBiomeController;
    }

    /**
     * Set the IBiomeController
     * 
     * @param iBiomeController IBiomeController
     */
    @Autowired
    public void setIIBiomeController(IBiomeController iBiomeController) {
        this.iBiomeController = iBiomeController;
    }

    /**
     * Find all biomes
     * 
     * @return list of BiomeDto
     */
    @GetMapping
    public List<BiomeDto> getAll() {
        return iBiomeController.findAll();
    }

    /**
     * Find a biome by id
     * 
     * @param id biome id
     * @return BiomeDto
     */
    @GetMapping("/{id}")
    public BiomeDto getById(@PathVariable(name = "id") final int id) {
        return iBiomeController.findById(id);
    }


}
