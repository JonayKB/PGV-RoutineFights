package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.PlayerDto;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IPlayerRepository;

public interface IPlayerController {
    /**
     * Get the IPlayerRepository
     * 
     * @return IPlayerRepository
     */
    public IPlayerRepository getIPlayerRepository();

    /**
     * Get the IItemRepository
     * 
     * @return IItemRepository
     */
    public IItemRepository getIItemRepository();

    /**
     * Set the IItemRepository
     * 
     * @param iItemController IItemRepository
     */
    public void setIItemRepository(IItemRepository iItemController);

    /**
     * Set the IPlayerRepository
     * 
     * @param playerRepository IPlayerRepository
     */
    public void setIPlayerRepository(IPlayerRepository playerRepository);

    /**
     * Find all players
     * 
     * @return list of PlayerDto
     */
    public List<PlayerDto> findAll();

    /**
     * Find a player by id
     * 
     * @param id player id
     * @return PlayerDto
     */
    public PlayerDto findById(Integer id);

    /**
     * Save a player
     * 
     * @param playerDto PlayerDto
     * @return PlayerDto
     */
    public PlayerDto save(PlayerDto playerDto);

    /**
     * Delete a player by id
     * 
     * @param id player id
     */
    public void deleteById(Integer id);

}
