package es.ies.puerto.routineFights.api.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


public class UserDTO {


    private int id;
    private String name;
    private String lastName;
    private String email;
    private String password;

   
    private RolDTO rol;

    private Set<PostDTO> posts;

    private Set<BadgeDTO> badges;

    private Set<ActivityDTO> activities;

    public UserDTO() {
    }

    public UserDTO(int id, String name, String lastName, String email, String password, RolDTO rol, Set<PostDTO> posts,
            Set<BadgeDTO> badges, Set<ActivityDTO> activities) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.posts = posts;
        this.badges = badges;
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

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDTO getRol() {
        return this.rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

    public Set<PostDTO> getPosts() {
        return this.posts;
    }

    public void setPosts(Set<PostDTO> posts) {
        this.posts = posts;
    }

    public Set<BadgeDTO> getBadges() {
        return this.badges;
    }

    public void setBadges(Set<BadgeDTO> badges) {
        this.badges = badges;
    }

    public Set<ActivityDTO> getActivities() {
        return this.activities;
    }

    public void setActivities(Set<ActivityDTO> activities) {

        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO user = (UserDTO) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
