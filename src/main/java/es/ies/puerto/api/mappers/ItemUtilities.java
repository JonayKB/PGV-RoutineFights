package es.ies.puerto.api.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Named;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

public interface ItemUtilities {
    @Named("getMobsIds")
    default List<Integer> getMobsIds(Item item) {
        List<Integer> mobsIds = new ArrayList<>();
        if (item.getMobs() == null || item.getMobs().isEmpty()) {
            return mobsIds;
        }
        for (Mob mob : item.getMobs()) {
            mobsIds.add(mob.getId());
        }
        return mobsIds;
    }

    @Named("getPlayersIds")
    default List<Integer> getPlayersIds(Item item) {
        List<Integer> playersIds = new ArrayList<>();
        if (item.getPlayers() == null || item.getPlayers().isEmpty()) {
            return playersIds;
        }
        for (Player player : item.getPlayers()) {
            playersIds.add(player.getId());
        }
        return playersIds;
    }
}
