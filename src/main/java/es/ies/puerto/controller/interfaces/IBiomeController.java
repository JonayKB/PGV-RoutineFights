package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;

public interface IBiomeController {
    public IBiomeRepository getIBiomeRepository();

    public void setIBiomeRepository(IBiomeRepository biomeRepository);

    public IDimensionRepository getIDimensionRepository();

    public void setIDimensionRepository(IDimensionRepository iDimensionRepository);

    public List<BiomeDto> findAll();

    public BiomeDto findById(Integer id);

    public BiomeDto save(BiomeDto biomeDto);

    public void deleteById(Integer id);
}
