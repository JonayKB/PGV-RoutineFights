package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.controller.DimensionController;
import es.ies.puerto.controller.ItemController;
import es.ies.puerto.controller.MobController;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.MobServiceSoapInterface")
public class MobServiceSoapImpl implements MobServiceSoapInterface {
    private MobController mobController;

    @Autowired
    public void setMobController(MobController mobController) {
        this.mobController = mobController;
    }

    @Override
    public List<MobDto> getAll() {
        return mobController.findAll();
    }

    @Override
    public MobDto getById(int mobId) {
        return mobController.findById(mobId);
    }

    @Override
    public Boolean deleteById(int mobId) {
        try {
            mobController.deleteById(mobId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public MobDto create(MobDto mob) {
        return mobController.save(mob);
    }

    
}