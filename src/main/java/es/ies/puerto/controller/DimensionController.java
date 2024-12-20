package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.mappers.DimensionMapper;
import es.ies.puerto.controller.interfaces.IDimensionController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;

@Controller
public class DimensionController implements IDimensionController {
    private IDimensionRepository iDimensionRepository;
    private IBiomeRepository iBiomeRepository;


    public IBiomeRepository getIBiomeRepository() {
        return this.iBiomeRepository;
    }
    @Override
    @Autowired
    public void setIBiomeRepository(IBiomeRepository iBiomeRepository) {
        this.iBiomeRepository = iBiomeRepository;
    }


    @Override
    public IDimensionRepository getIDimensionRepository() {
        return this.iDimensionRepository;
    }

    @Override
    @Autowired
    public void setIDimensionRepository(IDimensionRepository dimensionRepository) {
        this.iDimensionRepository = dimensionRepository;
    }

    @Override
    public List<DimensionDto> findAll() {
        List<DimensionDto> dimensionDtos = new ArrayList<>();
        List<Dimension> dimensions = iDimensionRepository.findAll();
        for (Dimension dimension : dimensions) {
            dimensionDtos.add(DimensionMapper.INSTANCE.toDimensionDto(dimension));
        }
        return dimensionDtos;
    }

    @Override
    public DimensionDto findById(Integer id) {
        Optional<Dimension> dimensionOptional = iDimensionRepository.findById(id);
        if (!dimensionOptional.isPresent()) {
            return new DimensionDto();
        }
        return DimensionMapper.INSTANCE.toDimensionDto(dimensionOptional.get());
    }

    @Override
    public DimensionDto save(DimensionDto dimensionDto) {
        Dimension dimension = DimensionMapper.INSTANCE.toDimension(dimensionDto);
        Set<Biome> biomes = new HashSet<>();
        if (dimensionDto.getBiomes()==null) {
            dimensionDto.setBiomes(new HashSet<>());
        }
        for (BiomeDto biomesDto : dimensionDto.getBiomes()) {
            Optional<Biome> biomeOptional = iBiomeRepository.findById(biomesDto.getId());
            if (biomeOptional.isPresent()) {
                Biome biome = biomeOptional.get();
                biomes.add(biome);
                biome.setDimension(dimension);
                dimension.getBiomes().add(biome);
            }
        }
        dimension.setBiomes(biomes);
        return DimensionMapper.INSTANCE.toDimensionDto(iDimensionRepository.save(dimension));
    }

    @Override
    public void deleteById(Integer id) {
        iDimensionRepository.deleteById(id);
    }

}
