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
import lombok.extern.java.Log;
import es.ies.puerto.model.entity.Rol;

@Controller
@Log
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
        log.info("Roles found: " + rolesDto.size());

        return rolesDto;
    }

    @Override
    public RolDto findById(Integer id) {
        Optional<Rol> rolOptional = rolRepository.findById(id);
        if (!rolOptional.isPresent()) {
            return new RolDto();
        }
        log.info("Rol found: " + rolOptional.get().getName());
        return RolMapper.INSTANCE.toRolDto(rolOptional.get());
    }

    @Override
    public RolDto save(RolDto rolDto) {
        Rol rol = RolMapper.INSTANCE.toRol(rolDto);
        Rol savedRol = rolRepository.save(rol);
        log.info("Rol saved: " + savedRol.getName());
        return RolMapper.INSTANCE.toRolDto(savedRol);
    }

    @Override
    public void deleteById(Integer id) {
        rolRepository.deleteById(id);
        log.info("Rol deleted: " + id);
    }

}
