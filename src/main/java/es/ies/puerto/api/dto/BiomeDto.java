package es.ies.puerto.api.dto;

import java.util.Set;
import java.util.Objects;
/**
 * BiomeDto
 */
public class BiomeDto {
    private Integer id;
    private String name;
    private Set<MobDto> spawnMobs;
    private Integer dimensionId;


    /**
     * Constructor
     */
    public BiomeDto() {
    }

    /**
     * Constructor
     * @param id of the biome
     * @param name of the biome
     * @param spawnMobs which spawns in that biome
     * @param dimensionId of the biome
     */
    public BiomeDto(Integer id, String name, Set<MobDto> spawnMobs, Integer dimensionId) {
        this.id = id;
        this.name = name;
        this.spawnMobs = spawnMobs;
        this.dimensionId = dimensionId;
    }

    /**
     * Get the id
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Set the id
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the name
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the spawnMobs
     * @return the spawnMobs
     */
    public Set<MobDto> getSpawnMobs() {
        return this.spawnMobs;
    }

    /**
     * Set the spawnMobs
     * @param spawnMobs the spawnMobs
     */
    public void setSpawnMobs(Set<MobDto> spawnMobs) {
        this.spawnMobs = spawnMobs;
    }

    /**
     * Get the dimensionId
     * @return the dimensionId
     */
    public Integer getDimensionId() {
        return this.dimensionId;
    }

    /**
     * Set the dimensionId
     * @param dimensionId the dimensionId
     */
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
