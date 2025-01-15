package es.ies.puerto.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.PlayerDto;
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
@RequestMapping("/api/v1/players")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE})

public class PlayerServiceV1 {
    IPlayerController iPlayerController;

    /**
     * Get the IPlayerController
     * 
     * @return IPlayerController
     */
    public IPlayerController getIPlayerController() {
        return this.iPlayerController;
    }

    /**
     * Set the IPlayerController
     * 
     * @param iPlayerController IPlayerController
     */
    @Autowired
    public void setIPlayerController(IPlayerController iPlayerController) {
        this.iPlayerController = iPlayerController;
    }

    /**
     * Find all players
     * 
     * @return list of PlayerDto
     */
    @GetMapping
    public List<PlayerDto> getAll() {
        return iPlayerController.findAll();
    }

    /**
     * Find a player by id
     * 
     * @param id player id
     * @return PlayerDto
     */
    @GetMapping("/{id}")
    public PlayerDto getById(@PathVariable(name = "id") final int id) {
        return iPlayerController.findById(id);
    }

    /**
     * Save a player
     * 
     * @param entity PlayerDto
     * @return PlayerDto
     */
    @PostMapping
    public PlayerDto save(@RequestBody PlayerDto entity) {
        return iPlayerController.save(entity);
    }

    /**
     * Delete a player by id
     * 
     * @param id player id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") final int id) {
        iPlayerController.deleteById(id);
    }
}
