package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.ItemDto;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;
import es.ies.puerto.model.repository.IPlayerRepository;

public interface IItemController {
    public IItemRepository getIItemRepository();

    public void setIItemRepository(IItemRepository iItemRepository);

    public IMobRepository getIMobRepository();

    public void setIMobRepository(IMobRepository iMobRepository);

    public IPlayerRepository getIPlayerRepository();

    public void setIPlayerRepository(IPlayerRepository iPlayerRepository);

    public List<ItemDto> findAll();

    public ItemDto findById(Integer id);

    public ItemDto save(ItemDto itemDto);

    public void deleteById(Integer id);
}
