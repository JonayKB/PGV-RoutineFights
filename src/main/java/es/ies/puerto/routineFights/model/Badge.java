package es.ies.puerto.routineFights.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Badge {
    @Id
    private int id;
    private int level;
    @ManyToOne()
    private CommunityEvent event;
    @ManyToMany()
    private Set<User> users;
    public Badge(){}
    public Badge(int id, int level, CommunityEvent event, Set<User> users) {
        this.id = id;
        this.level = level;
        this.event = event;
        this.users = users;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getLevel() {
        return this.level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public CommunityEvent getEvent() {
        return this.event;
    }
    public void setEvent(CommunityEvent event) {
        this.event = event;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Badge)) {
            return false;
        }
        Badge badge = (Badge) o;
        return id == badge.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
