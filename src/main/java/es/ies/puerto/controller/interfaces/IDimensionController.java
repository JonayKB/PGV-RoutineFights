package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;
/**
 * IDimensionController
 */
public interface IDimensionController {
    /**
     * Get the IDimensionRepository
     * 
     * @return IDimensionRepository
     */
    public IDimensionRepository getIDimensionRepository();

    /**
     * Get the IBiomeRepository
     * 
     * @return IBiomeRepository
     */
    public IBiomeRepository getIBiomeRepository();

    /**
     * Set the IDimensionRepository
     * 
     * @param dimensionRepository IDimensionRepository
     */
    public void setIDimensionRepository(IDimensionRepository dimensionRepository);

    /**
     * Set the IBiomeRepository
     * 
     * @param iBiomeRepository IBiomeRepository
     */
    public void setIBiomeRepository(IBiomeRepository iBiomeRepository);

    /**
     * Find all dimensions
     * 
     * @return list of DimensionDto
     */
    public List<DimensionDto> findAll();

    /**
     * Find a dimension by id
     * 
     * @param id dimension id
     * @return DimensionDto
     */
    public DimensionDto findById(Integer id);

    /**
     * Save a dimension
     * 
     * @param dimensionDto DimensionDto
     * @return DimensionDto
     */
    public DimensionDto save(DimensionDto dimensionDto);

    /**
     * Update a dimension
     * 
     * @param dimensionDto DimensionDto
     * @return DimensionDto
     */
    public DimensionDto update(DimensionDto dimensionDto);

    /**
     * Delete a dimension by id
     * 
     * @param id dimension id
     */
    public void deleteById(Integer id);
}
