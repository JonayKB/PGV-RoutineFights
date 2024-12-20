package es.ies.puerto.routineFights.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Rol {
    @Id
    private int id;
    private String name;
    public Rol() {
    }

    public Rol(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rol)) {
            return false;
        }
        Rol rol = (Rol) o;
        return id == rol.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
