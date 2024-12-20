package es.ies.puerto.api.mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;

import es.ies.puerto.api.dto.BiomeDto;
import es.ies.puerto.api.dto.DimensionDto;
import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.entity.Biome;
import es.ies.puerto.model.entity.Dimension;
import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

public class MapperUtil {
    public static final int LEVEL = 10;
    public static final String PASSWORD = "password";
    public static final String USERNAME = "username";
    public static final String NICKNAME = "nickname";
    public static final int PLAYER_ID = 10;
    public static final String ITEM_NAME = "itemName";
    public static final int ITEM_ID = 23;
    public static final int MOB_ID = 4;
    public static final String MOB_NAME = "mobName";
    public static final int BASE_ATTACK = 32;
    public static final int BASE_HEALTH = 23;
    public static final String ABILITY = "ability";
    public static final String BIOME_NAME = "biomeName";
    public static final int BIOME_ID = 2;
    public static final int DIMENSION_ID = 1;
    public static final String DIMENSION_NAME = "dimensionName";
    Dimension dimension;
    DimensionDto dimensionDto;

    Player player;
    PlayerDto playerDto;

    Mob mob;
    MobDto mobDto;

    Item item;
    ItemDto itemDto;

    Biome biome;
    BiomeDto biomeDto;

    Set<Biome> biomes;
    Set<BiomeDto> biomeDtos;

    Set<Mob> spawnMobs;
    Set<MobDto> spawnDtoMobs;

    List<Item> dropList;
    List<ItemDto> dropListDto;

    Set<Integer> biomesIds;

    List<Integer> playersIds;
    List<Integer> mobsIds;

    @BeforeEach
    public void beforeEach() {
        spawnDtoMobs = new HashSet<>();
        spawnMobs = new HashSet<>();
        biome = new Biome(BIOME_ID, BIOME_NAME, spawnMobs);
        biome.setDimension(new Dimension(DIMENSION_ID, DIMENSION_NAME, biomes));
        biomeDto = new BiomeDto(BIOME_ID, BIOME_NAME, spawnDtoMobs, DIMENSION_ID);

        biomes = new HashSet<>(Arrays.asList(biome));
        biomeDtos = new HashSet<>(Arrays.asList(biomeDto));

        dimension = new Dimension(DIMENSION_ID, DIMENSION_NAME, biomes);
        dimensionDto = new DimensionDto(DIMENSION_ID, DIMENSION_NAME, biomeDtos);

        

        item = new Item(ITEM_ID, ITEM_NAME);
        itemDto = new ItemDto(ITEM_ID, ITEM_NAME, playersIds, mobsIds);

        dropList = new ArrayList<>(Arrays.asList(item));
        dropListDto = new ArrayList<>(Arrays.asList(itemDto));
        biomesIds = new HashSet<>(Arrays.asList(BIOME_ID));

        mob = new Mob(MOB_ID, MOB_NAME, BASE_HEALTH, BASE_ATTACK, ABILITY, dropList);
        mob.setBiomes(biomes);
        mobDto = new MobDto(MOB_ID, MOB_NAME, BASE_HEALTH, BASE_ATTACK, ABILITY, dropListDto, biomesIds);

        

        player = new Player(PLAYER_ID, NICKNAME, USERNAME, PASSWORD, LEVEL, dropList);
        playerDto = new PlayerDto(PLAYER_ID, NICKNAME, USERNAME, PASSWORD, LEVEL, dropListDto);

        playersIds = new ArrayList<>(Arrays.asList(player.getId()));
        mobsIds = new ArrayList<>(Arrays.asList(mob.getId()));
        itemDto.setMobsIds(mobsIds);
        itemDto.setPlayersIds(playersIds);

        item.setMobs(new ArrayList<>(Arrays.asList(mob)));
        item.setPlayers(new ArrayList<>(Arrays.asList(player)));
    }
}
