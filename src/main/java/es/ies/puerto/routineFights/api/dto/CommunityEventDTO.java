package es.ies.puerto.routineFights.api.dto;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class CommunityEventDTO {

    private int id;
    private String title;

    private Set<BadgeDTO> badges;
    public CommunityEventDTO() {
    }
    public CommunityEventDTO(int id, String title, Set<BadgeDTO> badges) {
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
        if (!(o instanceof CommunityEventDTO)) {
            return false;
        }
        CommunityEventDTO communityEvent = (CommunityEventDTO) o;
        return id == communityEvent.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    
}
