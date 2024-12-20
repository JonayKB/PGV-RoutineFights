package es.ies.puerto.api.dto;

import java.util.List;
import java.util.Objects;

public class PlayerDto {
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private Integer level;
    private List<ItemDto> items;

    public PlayerDto() {
    }

    public PlayerDto(Integer id, String nickname, String username, String password, Integer level,
            List<ItemDto> items) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.level = level;
        this.items = items;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<ItemDto> getItems() {
        return this.items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PlayerDto)) {
            return false;
        }
        PlayerDto playerDto = (PlayerDto) o;
        return Objects.equals(id, playerDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nickname='" + getNickname() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", level='" + getLevel() + "'" +
                ", items='" + getItems() + "'" +
                "}";
    }

}
