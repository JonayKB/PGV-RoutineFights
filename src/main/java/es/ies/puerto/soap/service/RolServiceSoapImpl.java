package es.ies.puerto.soap.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.controller.RolController;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.ies.puerto.soap.service.RolServiceSoapInterface")
public class RolServiceSoapImpl implements RolServiceSoapInterface {
    private RolController rolController;
    private Logger logger = Logger.getLogger(RolServiceSoapImpl.class.getName());

    @Autowired
    public void setRolController(RolController rolController) {
        this.rolController = rolController;
    }

    @Override
    public RolDto create(RolDto rolDto) {
        return rolController.save(rolDto);
    }

    @Override
    public RolDto getById(int id) {
        return rolController.findById(id);
    }

    @Override
    public List<RolDto> getAll() {
        logger.info("getAll");
        return rolController.findAll();
    }

    @Override
    public Boolean deleteById(int id) {
        try {
            rolController.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}