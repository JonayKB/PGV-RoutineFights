package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.BiomeServiceSoapInterface")
public class BiomeServiceSoapImpl implements BiomeServiceSoapInterface {
    private BiomeController biomeController;

    @Autowired
    public void setBiomeController(BiomeController biomeController) {
        this.biomeController = biomeController;
    }

    @Override
    public List<BiomeDto> getAll() {
        return biomeController.findAll();
    }

    @Override
    public BiomeDto getById(int biomeId) {
        return biomeController.findById(biomeId);
    }

    @Override
    public Boolean deleteById(int biomeId) {
        try {
            biomeController.deleteById(biomeId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public BiomeDto create(BiomeDto biome) {
        return biomeController.save(biome);
    }

}