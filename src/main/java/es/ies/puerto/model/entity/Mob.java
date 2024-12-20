package es.ies.puerto.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity()
@Table(name = "Mobs")
public class Mob implements Serializable {
    private static final long serialVersionUID = -6714424968L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer baseHealth;
    private Integer baseAttack;
    private String specialAbility;

    @ManyToMany(mappedBy = "mobs")
    private List<Item> dropList;

    @ManyToMany()
    private Set<Biome> biomes;

    public Mob() {
    }

    public Mob(Integer id, String name, Integer baseHealth, Integer baseAttack, String specialAbility,
            List<Item> dropList) {
        this.id = id;
        this.name = name;
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.specialAbility = specialAbility;
        this.dropList = dropList;
    }

    public Set<Biome> getBiomes() {
        return this.biomes;
    }

    public void setBiomes(Set<Biome> biomes) {
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

    public List<Item> getDropList() {
        return this.dropList;
    }

    public void setDropList(List<Item> dropList) {
        this.dropList = dropList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mob)) {
            return false;
        }
        Mob mob = (Mob) o;
        return Objects.equals(id, mob.id);
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
                "}";
    }

}
