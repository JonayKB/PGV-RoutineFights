package es.ies.puerto.api.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

class MobMapperTest extends MapperUtil {
    @Test
    void toMob() {
        Mob mobObtained = MobMapper.INSTANCE.toMob(mobDto);


        Assertions.assertEquals(mob.getId(), mobObtained.getId());
        Assertions.assertEquals(mob.getBaseAttack(), mobObtained.getBaseAttack());
        Assertions.assertEquals(mob.getBaseHealth(), mobObtained.getBaseHealth());
        Assertions.assertEquals(mob.getName(), mobObtained.getName());
        Assertions.assertEquals(mob.getSpecialAbility(), mobObtained.getSpecialAbility());
        //Assertions.assertEquals(mob.getBiomes(), mobObtained.getBiomes());
        Assertions.assertEquals(mob.getDropList(), mobObtained.getDropList());

        mobObtained = MobMapper.INSTANCE.toMob(null);

        mobDto.setDropList(null);
        mobDto.setBiomesIds(null);

        mobObtained = MobMapper.INSTANCE.toMob(mobDto);


    }

    @Test
    void toMobDto() {
        MobDto mobDtoObtained = MobMapper.INSTANCE.toMobDto(mob);


        Assertions.assertEquals(mobDto.getId(), mobDtoObtained.getId());
        Assertions.assertEquals(mobDto.getBaseAttack(), mobDtoObtained.getBaseAttack());
        Assertions.assertEquals(mobDto.getBaseHealth(), mobDtoObtained.getBaseHealth());
        Assertions.assertEquals(mobDto.getName(), mobDtoObtained.getName());
        Assertions.assertEquals(mobDto.getSpecialAbility(), mobDtoObtained.getSpecialAbility());
        Assertions.assertEquals(mobDto.getBiomesIds(), mobDtoObtained.getBiomesIds());
        Assertions.assertEquals(mobDto.getDropList(), mobDtoObtained.getDropList());

        mobDtoObtained = MobMapper.INSTANCE.toMobDto(null);

        mob.setDropList(null);
        mob.setBiomes(null);

        mobDtoObtained = MobMapper.INSTANCE.toMobDto(mob);


    }
}
