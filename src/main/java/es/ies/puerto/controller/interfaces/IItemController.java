package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;
import es.ies.puerto.model.repository.IPlayerRepository;

public interface IItemController {
    /**
     * Get the IItemRepository
     * @return IItemRepository
     */
    public IItemRepository getIItemRepository();

    /**
     * Set the IItemRepository
     * @param iItemRepository IItemRepository
     */
    public void setIItemRepository(IItemRepository iItemRepository);

    /**
     * Get the IMobRepository
     * @return IMobRepository
     */
    public IMobRepository getIMobRepository();

    /**
     * Set the IMobRepository
     * @param iMobRepository IMobRepository
     */
    public void setIMobRepository(IMobRepository iMobRepository);

    /**
     * Get the IPlayerRepository
     * @return IPlayerRepository
     */
    public IPlayerRepository getIPlayerRepository();

    /**
     * Set the IPlayerRepository
     * @param iPlayerRepository IPlayerRepository
     */
    public void setIPlayerRepository(IPlayerRepository iPlayerRepository);

    /**
     * Find all items
     * @return list of ItemDto
     */
    public List<ItemDto> findAll();

    /**
     * Find an item by id
     * @param id item id
     * @return ItemDto
     */
    public ItemDto findById(Integer id);

    /**
     * Save an item
     * @param itemDto ItemDto
     * @return ItemDto
     */
    public ItemDto save(ItemDto itemDto);

    /**
     * Delete an item by id
     * @param id item id
     */
    public void deleteById(Integer id);
}
