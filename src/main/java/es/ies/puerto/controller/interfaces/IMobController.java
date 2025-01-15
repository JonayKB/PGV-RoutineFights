package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;

public interface IMobController {
    /**
     * Get the IBiomeRepository
     * 
     * @return IBiomeRepository
     */
    public IItemRepository getIItemRepository();

    /**
     * Set the IBiomeRepository
     * 
     * @param iBiomeRepository IBiomeRepository
     */
    public void setIBiomeRepository(IBiomeRepository iBiomeRepository);

    /**
     * Get the IMobRepository
     * 
     * @return IMobRepository
     */
    public IBiomeRepository getIBiomeRepository();

    /**
     * Set the IMobRepository
     * 
     * @param iMobRepository IMobRepository
     */
    public void setIItemRepository(IItemRepository iItemController);

    /**
     * Get the IMobRepository
     * 
     * @return IMobRepository
     */
    public IMobRepository getIMobRepository();

    /**
     * Set the IMobRepository
     * 
     * @param mobRepository IMobRepository
     */
    public void setIMobRepository(IMobRepository mobRepository);

    /**
     * Find all mobs
     * 
     * @return list of MobDto
     */
    public List<MobDto> findAll();

    /**
     * Find a mob by id
     * 
     * @param id mob id
     * @return MobDto
     */
    public MobDto findById(Integer id);

    /**
     * Save a mob
     * 
     * @param mobDto MobDto
     * @return MobDto
     */
    public MobDto save(MobDto mobDto);

    /**
     * Delete a mob by id
     * 
     * @param id mob id
     */
    public void deleteById(Integer id);
}
