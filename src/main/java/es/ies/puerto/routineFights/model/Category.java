package es.ies.puerto.routineFights.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Activity> activities;
    public Category() {
    }
    public Category(int id, String name, Set<Activity> activities) {
        this.id = id;
        this.name = name;
        this.activities = activities;
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
    public Set<Activity> getActivities() {
        return this.activities;
    }
    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Category)) {
            return false;
        }
        Category category = (Category) o;
        return id == category.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
