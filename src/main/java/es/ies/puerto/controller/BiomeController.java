package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.mappers.BiomeMapper;
import es.ies.puerto.controller.interfaces.IBiomeController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IDimensionRepository;

@Controller
public class BiomeController implements IBiomeController {
    private IBiomeRepository iBiomeRepository;
    private IDimensionRepository iDimensionRepository;

    @Override
    public IBiomeRepository getIBiomeRepository() {
        return this.iBiomeRepository;
    }

    @Override
    @Autowired
    public void setIBiomeRepository(IBiomeRepository biomeRepository) {
        this.iBiomeRepository = biomeRepository;
    }

    @Override
    public IDimensionRepository getIDimensionRepository() {
        return this.iDimensionRepository;
    }

    @Override
    @Autowired
    public void setIDimensionRepository(IDimensionRepository iDimensionRepository) {
        this.iDimensionRepository = iDimensionRepository;
    }

    @Override
    public List<BiomeDto> findAll() {
        List<BiomeDto> biomeDtos = new ArrayList<>();
        List<Biome> biomes = iBiomeRepository.findAll();
        for (Biome biome : biomes) {
            biomeDtos.add(BiomeMapper.INSTANCE.toBiomeDto(biome));
        }
        return biomeDtos;
    }

    @Override
    public BiomeDto findById(Integer id) {
        Optional<Biome> biomeOptional = iBiomeRepository.findById(id);
        if (!biomeOptional.isPresent()) {
            return new BiomeDto();
        }
        return BiomeMapper.INSTANCE.toBiomeDto(biomeOptional.get());
    }

    @Override
    public BiomeDto save(BiomeDto biomeDto) {
        Biome biome = BiomeMapper.INSTANCE.toBiome(biomeDto);
        Optional<Dimension> dimensionOptional = iDimensionRepository.findById(biomeDto.getDimensionId());
        if (dimensionOptional.isPresent()) {
            biome.setDimension(dimensionOptional.get());
        }
        return BiomeMapper.INSTANCE.toBiomeDto(iBiomeRepository.save(biome));
    }

    @Override
    public void deleteById(Integer id) {
        iBiomeRepository.deleteById(id);
    }

}
