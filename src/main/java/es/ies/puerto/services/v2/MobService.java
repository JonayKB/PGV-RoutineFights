package es.ies.puerto.services.v2;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * MobService
 */
@RestController("MobServiceV2")
@RequestMapping("/api/v2/mobs")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class MobService {
    IMobController iMobController;

    /**
     * Get the IMobController
     * 
     * @return IMobController
     */
    public IMobController getIMobController() {
        return this.iMobController;
    }
    /**
     * Set the IMobController
     * 
     * @param iMobController IMobController
     */
    @Autowired
    public void setIMobController(IMobController iMobController) {
        this.iMobController = iMobController;
    }

    /**
     * Find all mobs
     * 
     * @return list of MobDto
     */
    @GetMapping
    public List<MobDto> getAll() {
        return iMobController.findAll();
    }

    /**
     * Find a mob by id
     * 
     * @param id mob id
     * @return MobDto
     */
    @GetMapping("/{id}")
    public MobDto getById(@PathVariable(name = "id") final int id) {
        return iMobController.findById(id);
    }

}
