package es.ies.puerto.routineFights.api.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class BadgeDTO {

    private int id;
    private int level;

    private CommunityEventDTO event;

    private Set<UserDTO> users;
    public BadgeDTO(){}
    public BadgeDTO(int id, int level, CommunityEventDTO event, Set<UserDTO> users) {
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
    public CommunityEventDTO getEvent() {
        return this.event;
    }
    public void setEvent(CommunityEventDTO event) {
        this.event = event;
    }
    public Set<UserDTO> getUsers() {
        return this.users;
    }
    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BadgeDTO)) {
            return false;
        }
        BadgeDTO badge = (BadgeDTO) o;
        return id == badge.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
