package es.ies.puerto.routineFights.model;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class CommunityEvent {
    @Id
    private int id;
    private String title;
    @OneToMany(mappedBy = "event")
    private Set<Badge> badges;
    public CommunityEvent() {
    }
    public CommunityEvent(int id, String title, Set<Badge> badges) {
        this.id = id;
        this.title = title;
        this.badges = badges;
    }

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CommunityEvent)) {
            return false;
        }
        CommunityEvent communityEvent = (CommunityEvent) o;
        return id == communityEvent.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    
}
