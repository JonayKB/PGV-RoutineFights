package es.ies.puerto.routineFights.api.dto;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class ActivityDTO {

    private int id;
    private String name;

    private CategoryDTO category;
    public ActivityDTO(){}

    public ActivityDTO(int id, String name, CategoryDTO category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public CategoryDTO getCategory() {
        return this.category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ActivityDTO)) {
            return false;
        }
        ActivityDTO activity = (ActivityDTO) o;
        return id == activity.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    

}
