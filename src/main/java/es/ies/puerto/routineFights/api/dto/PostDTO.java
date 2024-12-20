package es.ies.puerto.routineFights.api.dto;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class PostDTO {

    private int id;

    private UserDTO user;

    private ActivityDTO activity;
    public PostDTO() {
    }

    public PostDTO(int id, UserDTO user, ActivityDTO activity) {
        this.id = id;
        this.user = user;
        this.activity = activity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return this.user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ActivityDTO getActivity() {
        return this.activity;
    }

    public void setActivity(ActivityDTO activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostDTO)) {
            return false;
        }
        PostDTO post = (PostDTO) o;
        return id == post.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
