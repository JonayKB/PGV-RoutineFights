package es.ies.puerto.routineFights.api.dto;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class CategoryDTO {

    private int id;
    private String name;

    public CategoryDTO() {
    }
    public CategoryDTO(int id, String name) {
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
        if (!(o instanceof CategoryDTO)) {
            return false;
        }
        CategoryDTO category = (CategoryDTO) o;
        return id == category.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
