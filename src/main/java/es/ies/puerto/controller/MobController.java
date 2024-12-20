package es.ies.puerto.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.api.mappers.MobMapper;
import es.ies.puerto.api.mappers.PlayerMapper;
import es.ies.puerto.controller.interfaces.IItemController;
import es.ies.puerto.controller.interfaces.IMobController;
import es.ies.puerto.controller.interfaces.IPlayerController;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;
import es.ies.puerto.model.repository.IPlayerRepository;

@Controller
public class MobController implements IMobController {
    private IMobRepository iMobRepository;
    private IItemRepository iItemRepository;
    private IBiomeRepository iBiomeRepository;

    public IBiomeRepository getIBiomeRepository() {
        return this.iBiomeRepository;
    }
    @Autowired
    public void setIBiomeRepository(IBiomeRepository iBiomeRepository) {
        this.iBiomeRepository = iBiomeRepository;
    }


    public IItemRepository getIItemRepository() {
        return this.iItemRepository;
    }

    @Autowired
    public void setIItemRepository(IItemRepository iItemController) {
        this.iItemRepository = iItemController;
    }

    @Override
    public IMobRepository getIMobRepository() {
        return this.iMobRepository;
    }

    @Override
    @Autowired
    public void setIMobRepository(IMobRepository mobRepository) {
        this.iMobRepository = mobRepository;
    }

    @Override
    public List<MobDto> findAll() {
        List<MobDto> mobsDtos = new ArrayList<>();
        List<Mob> mobs = iMobRepository.findAll();
        for (Mob mob : mobs) {
            mobsDtos.add(MobMapper.INSTANCE.toMobDto(mob));
        }
        return mobsDtos;
    }

    @Override
    public MobDto findById(Integer id) {
        Optional<Mob> mobOptional = iMobRepository.findById(id);
        if (!mobOptional.isPresent()) {
            return new MobDto();
        }
        return MobMapper.INSTANCE.toMobDto(mobOptional.get());
    }

    @Override
    public MobDto save(MobDto mobDto) {
        List<Item> items = new ArrayList<>();
        Set<Biome> biomes = new HashSet<>();
        Mob mob = MobMapper.INSTANCE.toMob(mobDto);
        for (ItemDto itemDto : mobDto.getDropList()) {
            Optional<Item> itemOptional = iItemRepository.findById(itemDto.getId());
            if (itemOptional.isPresent()) {
                Item item = itemOptional.get();
                items.add(item);
                if (item.getMobs() == null) {
                    item.setMobs(new ArrayList<>());
                }
                item.getMobs().add(mob);
            }

        }

        mob.setDropList(items);

        for (Integer idBioma : mobDto.getBiomesIds()) {
            Optional<Biome> biomeOptional = iBiomeRepository.findById(idBioma);
            if (biomeOptional.isPresent()) {
                Biome biome = biomeOptional.get();
                biomes.add(biome);
                if (biome.getSpawnMobs() == null) {
                    biome.setSpawnMobs(new HashSet<>());
                }
                biome.getSpawnMobs().add(mob);
            }
        }
        mob.setBiomes(biomes);

        return MobMapper.INSTANCE.toMobDto(iMobRepository.save(mob));
    }

    @Override
    public void deleteById(Integer id) {
        iMobRepository.deleteById(id);
    }

}
