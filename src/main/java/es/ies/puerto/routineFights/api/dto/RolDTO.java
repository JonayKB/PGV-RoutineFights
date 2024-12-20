package es.ies.puerto.routineFights.api.dto;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class RolDTO {

    private int id;
    private String name;
    public RolDTO() {
    }

    public RolDTO(int id, String name) {
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
        if (!(o instanceof RolDTO)) {
            return false;
        }
        RolDTO rol = (RolDTO) o;
        return id == rol.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
