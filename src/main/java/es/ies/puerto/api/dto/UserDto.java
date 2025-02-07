package es.ies.puerto.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * ItemDto
 */
public class UserDto  {


    private Integer id;
    private String username;
    private String password;

    private RolDto rol;


    public UserDto() {
    }
    public UserDto(Integer id, String username, String password, RolDto rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public RolDto getRol() {
        return this.rol;
    }
    public void setRol(RolDto rol) {
        this.rol = rol;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto user = (UserDto) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", rol='" + getRol() + "'" +
                "}";
    }

}
