package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.api.mappers.RolMapper;
import es.ies.puerto.controller.interfaces.IRolController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;
import es.ies.puerto.model.repository.IRolRepository;
import es.ies.puerto.model.entity.Rol;

@Controller
public class RolController implements IRolController {
    private IRolRepository rolRepository;

    @Override
    public IRolRepository getIRolRepository() {
        return this.rolRepository;

    }

    @Override
    @Autowired
    public void setIRolRepository(IRolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<RolDto> findAll() {
        List<Rol> roles = rolRepository.findAll();
        List<RolDto> rolesDto = new ArrayList<>();
        for (Rol rol : roles) {
            rolesDto.add(RolMapper.INSTANCE.toRolDto(rol));
        }
        return rolesDto;
    }

    @Override
    public RolDto findById(Integer id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (!rolOptional.isPresent()) {
            return new RolDto();
        }
        return RolMapper.INSTANCE.toRolDto(rolOptional.get());
    }

    @Override
    public RolDto save(RolDto rolDto) {
        Rol rol = RolMapper.INSTANCE.toRol(rolDto);
        Rol savedRol = rolRepository.save(rol);
        return RolMapper.INSTANCE.toRolDto(savedRol);
    }

    @Override
    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
    }

}
