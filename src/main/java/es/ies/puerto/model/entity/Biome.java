package es.ies.puerto.model.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Objects;
/**
 * Biome
 */
@Entity()
@Table(name = "Biomes")
public class Biome implements Serializable {
    private static final long serialVersionUID = -51875397L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "biomes", fetch = FetchType.EAGER)
    private Set<Mob> spawnMobs;

    @ManyToOne(fetch = FetchType.EAGER)
    private Dimension dimension;

    /**
     * Constructor
     */
    public Biome() {
    }

    /**
     * Constructor
     * @param id of the biome
     * @param name of the biome
     * @param spawnMobs which spawns in that biome
     */
    public Biome(Integer id, String name, Set<Mob> spawnMobs) {
        this.id = id;
        this.name = name;
        this.spawnMobs = spawnMobs;
    }

    /**
     * Get the dimension
     * @return the dimension
     */
    public Dimension getDimension() {
        return this.dimension;
    }

    /**
     * Set the dimension
     * @param dimension the dimension
     */
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
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
     * Get the spawn mobs
     * @return the spawn mobs
     */
    public Set<Mob> getSpawnMobs() {
        return this.spawnMobs;
    }

    /**
     * Set the spawn mobs
     * @param spawnMobs the spawn mobs
     */
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
