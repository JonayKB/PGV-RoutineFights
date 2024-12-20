package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.model.repository.IRolRepository;

public interface IRolController {
    public IRolRepository getIRolRepository();

    public void setIRolRepository(IRolRepository rolRepository);

    public List<RolDto> findAll();

    public RolDto findById(Integer id);

    public RolDto save(RolDto rolDto);

    public void deleteById(Integer id);
}
