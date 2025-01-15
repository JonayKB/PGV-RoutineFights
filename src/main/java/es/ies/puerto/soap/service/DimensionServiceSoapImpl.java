package es.ies.puerto.soap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.BiomeController;
import es.ies.puerto.controller.DimensionController;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.DimensionServiceSoapInterface")
public class DimensionServiceSoapImpl implements DimensionServiceSoapInterface {
    private DimensionController dimensionController;

    @Autowired
    public void setDimensionController(DimensionController dimensionController) {
        this.dimensionController = dimensionController;
    }



    @Override
    public List<DimensionDto> getAll() {
        return dimensionController.findAll();
    }

    @Override
    public DimensionDto getById(int dimensionId) {
        return dimensionController.findById(dimensionId);
    }

    @Override
    public Boolean deleteById(int dimensionId) {
        try {
            dimensionController.deleteById(dimensionId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public DimensionDto create(DimensionDto dimension) {
        return dimensionController.save(dimension);
    }



   

}