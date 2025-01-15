package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.controller.DimensionController;
import es.ies.puerto.controller.ItemController;
import es.ies.puerto.controller.MobController;
import es.ies.puerto.controller.PlayerController;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.PlayerServiceSoapInterface")
public class PlayerServiceSoapImpl implements PlayerServiceSoapInterface {
    private PlayerController playerController;

    @Autowired
    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    @Override
    public List<PlayerDto> getAll() {
        return playerController.findAll();
    }

    @Override
    public PlayerDto getById(int playerId) {
        return playerController.findById(playerId);
    }

    @Override
    public Boolean deleteById(int playerId) {
        try {
            playerController.deleteById(playerId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public PlayerDto create(PlayerDto player) {
        return playerController.save(player);
    }

    
}