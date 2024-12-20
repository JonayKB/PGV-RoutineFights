package es.ies.puerto.api.dto;

import java.util.List;
import java.util.Objects;

public class ItemDto {
    private Integer id;
    private String name;
    private List<Integer> playersIds;
    private List<Integer> mobsIds;
    

    public ItemDto() {
    }

    public ItemDto(Integer id, String name, List<Integer> playersIds, List<Integer> mobsIds) {
        this.id = id;
        this.name = name;
        this.playersIds = playersIds;
        this.mobsIds = mobsIds;
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

    public List<Integer> getPlayersIds() {
        return this.playersIds;
    }

    public void setPlayersIds(List<Integer> playersIds) {
        this.playersIds = playersIds;
    }

    public List<Integer> getMobsIds() {
        return this.mobsIds;
    }

    public void setMobsIds(List<Integer> mobsIds) {
        this.mobsIds = mobsIds;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ItemDto)) {
            return false;
        }
        ItemDto itemDto = (ItemDto) o;
        return Objects.equals(id, itemDto.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", playersIds='" + getPlayersIds() + "'" +
            ", mobsIds='" + getMobsIds() + "'" +
            "}";
    }
    
}
