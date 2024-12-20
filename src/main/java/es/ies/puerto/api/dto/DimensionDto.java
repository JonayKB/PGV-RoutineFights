package es.ies.puerto.api.dto;

import java.util.Set;
import java.util.Objects;

public class DimensionDto {
    private Integer id;
    private String name;
    private Set<BiomeDto> biomes;


    public DimensionDto() {
    }

    public DimensionDto(Integer id, String name, Set<BiomeDto> biomes) {
        this.id = id;
        this.name = name;
        this.biomes = biomes;
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

    public Set<BiomeDto> getBiomes() {
        return this.biomes;
    }

    public void setBiomes(Set<BiomeDto> biomes) {
        this.biomes = biomes;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DimensionDto)) {
            return false;
        }
        DimensionDto dimensionDto = (DimensionDto) o;
        return Objects.equals(id, dimensionDto.id) ;
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
            ", biomes='" + getBiomes() + "'" +
            "}";
    }
    
}
