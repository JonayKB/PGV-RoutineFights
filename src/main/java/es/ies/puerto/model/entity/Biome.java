package es.ies.puerto.model.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity()
@Table(name = "Biomes")
public class Biome implements Serializable {
    private static final long serialVersionUID = -51875397L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "biomes")
    private Set<Mob> spawnMobs;

    @ManyToOne()
    private Dimension dimension;

    public Biome() {
    }

    public Biome(Integer id, String name, Set<Mob> spawnMobs) {
        this.id = id;
        this.name = name;
        this.spawnMobs = spawnMobs;
    }

    public Dimension getDimension() {
        return this.dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
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

    public Set<Mob> getSpawnMobs() {
        return this.spawnMobs;
    }

    public void setSpawnMobs(Set<Mob> spawnMobs) {
        this.spawnMobs = spawnMobs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Biome)) {
            return false;
        }
        Biome biomes = (Biome) o;
        return Objects.equals(id, biomes.id);
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
                "}";
    }

}
