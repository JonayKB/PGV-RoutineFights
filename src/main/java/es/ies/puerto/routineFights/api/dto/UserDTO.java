package es.ies.puerto.routineFights.api.dto;

import java.io.Serializable;
import java.util.Set;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String lastName;
    private String email;
    private String rolName; 
    private Set<Integer> postIds;
    private Set<Integer> badgeIds; 
    private Set<Integer> activityIds; 

    public UserDTO() {
    }

    public UserDTO(int id, String name, String lastName, String email, String rolName, Set<Integer> postIds,
            Set<Integer> badgeIds, Set<Integer> activityIds) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.rolName = rolName;
        this.postIds = postIds;
        this.badgeIds = badgeIds;
        this.activityIds = activityIds;
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

    public String getRolName() {
        return this.rolName;
    }

    public void setRolName(String rolName) {
        this.rolName = rolName;
    }

    public Set<Integer> getPostIds() {
        return this.postIds;
    }

    public void setPostIds(Set<Integer> postIds) {
        this.postIds = postIds;
    }

    public Set<Integer> getBadgeIds() {
        return this.badgeIds;
    }

    public void setBadgeIds(Set<Integer> badgeIds) {
        this.badgeIds = badgeIds;
    }

    public Set<Integer> getActivityIds() {
        return this.activityIds;
    }

    public void setActivityIds(Set<Integer> activityIds) {
        this.activityIds = activityIds;
    }
}
