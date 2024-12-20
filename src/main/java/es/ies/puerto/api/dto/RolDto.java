package es.ies.puerto.api.dto;

public class RolDto {
    private Integer id;
    private String name;
    public RolDto() {
    }
    public RolDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                "}";
    
    }
    
}
