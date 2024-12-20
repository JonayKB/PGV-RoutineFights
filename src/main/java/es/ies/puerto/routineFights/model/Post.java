package es.ies.puerto.routineFights.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Post {
    @Id
    private int id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Activity activity;
    public Post() {
    }

    public Post(int id, User user, Activity activity) {
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

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return this.activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
