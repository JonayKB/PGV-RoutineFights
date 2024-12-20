package es.ies.puerto.api.dto;

import java.util.Set;
import java.util.Objects;

public class BiomeDto {
    private Integer id;
    private String name;
    private Set<MobDto> spawnMobs;
    private Integer dimensionId;


    public BiomeDto() {
    }

    public BiomeDto(Integer id, String name, Set<MobDto> spawnMobs, Integer dimensionId) {
        this.id = id;
        this.name = name;
        this.spawnMobs = spawnMobs;
        this.dimensionId = dimensionId;
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

    public Set<MobDto> getSpawnMobs() {
        return this.spawnMobs;
    }

    public void setSpawnMobs(Set<MobDto> spawnMobs) {
        this.spawnMobs = spawnMobs;
    }

    public Integer getDimensionId() {
        return this.dimensionId;
    }

    public void setDimensionId(Integer dimensionId) {
        this.dimensionId = dimensionId;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BiomeDto)) {
            return false;
        }
        BiomeDto biomeDto = (BiomeDto) o;
        return Objects.equals(id, biomeDto.id) ;
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
            ", spawnMobs='" + getSpawnMobs() + "'" +
            ", dimensionId='" + getDimensionId() + "'" +
            "}";
    }
    
}
