package es.ies.puerto.api.mappers;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Mob;

@Mapper(uses = { ItemMapper.class })
public interface MobMapper {
    MobMapper INSTANCE = Mappers.getMapper(MobMapper.class);

    @Mapping(source = "mob", target = "biomesIds", qualifiedByName = "getBiomesIds")
    public MobDto toMobDto(Mob mob);

    public Mob toMob(MobDto mobDto);

    @Named("getBiomesIds")
    default Set<Integer> getBiomesIds(Mob mob) {
        Set<Integer> biomesIds = new HashSet<>();
        if (mob.getBiomes()==null || mob.getBiomes().isEmpty()) {
            return biomesIds;
        }
        for (Biome biome : mob.getBiomes()) {
            biomesIds.add(biome.getId());
        }
        return biomesIds;
    }
}
