package es.ies.puerto.api.dto;

import java.util.List;
import java.util.Set;
import java.util.Objects;

public class MobDto {
    private Integer id;
    private String name;
    private Integer baseHealth;
    private Integer baseAttack;
    private String specialAbility;
    private List<ItemDto> dropList;
    private Set<Integer> biomesIds;

    public MobDto() {
    }

    public MobDto(Integer id, String name, Integer baseHealth, Integer baseAttack, String specialAbility, List<ItemDto> dropList, Set<Integer> biomesIds) {
        this.id = id;
        this.name = name;
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.specialAbility = specialAbility;
        this.dropList = dropList;
        this.biomesIds = biomesIds;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseHealth() {
        return this.baseHealth;
    }

    public void setBaseHealth(Integer baseHealth) {
        this.baseHealth = baseHealth;
    }

    public Integer getBaseAttack() {
        return this.baseAttack;
    }

    public void setBaseAttack(Integer baseAttack) {
        this.baseAttack = baseAttack;
    }

    public String getSpecialAbility() {
        return this.specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    public List<ItemDto> getDropList() {
        return this.dropList;
    }

    public void setDropList(List<ItemDto> dropList) {
        this.dropList = dropList;
    }

    public Set<Integer> getBiomesIds() {
        return this.biomesIds;
    }

    public void setBiomesIds(Set<Integer> biomesIds) {
        this.biomesIds = biomesIds;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MobDto)) {
            return false;
        }
        MobDto mobDto = (MobDto) o;
        return Objects.equals(id, mobDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", baseHealth='" + getBaseHealth() + "'" +
            ", baseAttack='" + getBaseAttack() + "'" +
            ", specialAbility='" + getSpecialAbility() + "'" +
            ", dropList='" + getDropList() + "'" +
            ", biomesIds='" + getBiomesIds() + "'" +
            "}";
    }

}
