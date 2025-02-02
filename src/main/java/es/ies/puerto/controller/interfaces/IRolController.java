package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.RolDto;
import es.ies.puerto.model.repository.IRolRepository;

public interface IRolController {
    /**
     * Get the IRolRepository
     * 
     * @return IRolRepository
     */
    public IRolRepository getIRolRepository();

    /**
     * Set the IRolRepository
     * 
     * @param rolRepository IRolRepository
     */
    public void setIRolRepository(IRolRepository rolRepository);

    /**
     * Find all roles
     * 
     * @return list of RolDto
     */
    public List<RolDto> findAll();

    /**
     * Find a role by id
     * 
     * @param id role id
     * @return RolDto
     */
    public RolDto findById(Integer id);

    /**
     * Save a role
     * 
     * @param rolDto RolDto
     * @return RolDto
     */
    public RolDto save(RolDto rolDto);


    public RolDto update(RolDto rolDto);


    /**
     * Delete a role by id
     * 
     * @param id role id
     */
    public void deleteById(Integer id);
}
