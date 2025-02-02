package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;

public interface IBiomeController {
    /**
     * Get the IBiomeRepository
     * 
     * @return IBiomeRepository
     */
    public IBiomeRepository getIBiomeRepository();

    /**
     * Set the IBiomeRepository
     * 
     * @param biomeRepository IBiomeRepository
     */
    public void setIBiomeRepository(IBiomeRepository biomeRepository);

    /**
     * Get the IDimensionRepository
     * 
     * @return IDimensionRepository
     */
    public IDimensionRepository getIDimensionRepository();

    /**
     * Set the IDimensionRepository
     * 
     * @param iDimensionRepository IDimensionRepository
     */
    public void setIDimensionRepository(IDimensionRepository iDimensionRepository);

    /**
     * Find all biomes
     * 
     * @return list of BiomeDto
     */
    public List<BiomeDto> findAll();

    /**
     * Find a biome by id
     * 
     * @param id biome id
     * @return BiomeDto
     */
    public BiomeDto findById(Integer id);

    /**
     * Save a biome
     * 
     * @param biomeDto BiomeDto
     * @return BiomeDto
     */
    public BiomeDto save(BiomeDto biomeDto);

    public BiomeDto update(BiomeDto biomeDto);

    /**
     * Delete a biome by id
     * 
     * @param id biome id
     */
    public void deleteById(Integer id);
}
