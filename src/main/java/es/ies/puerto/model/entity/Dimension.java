package es.ies.puerto.model.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity()
@Table(name = "Dimensions")
public class Dimension implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "dimension")
    private Set<Biome> biomes;

    public Dimension() {
    }

    public Dimension(Integer id, String name, Set<Biome> biomes) {
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

    public Set<Biome> getBiomes() {
        return this.biomes;
    }

    public void setBiomes(Set<Biome> biomes) {
        this.biomes = biomes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) o;
        return Objects.equals(id, dimension.id);
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
