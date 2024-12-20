package es.ies.puerto.controller.interfaces;

import java.util.List;

import es.ies.puerto.api.dto.MobDto;
import es.ies.puerto.model.repository.IBiomeRepository;
import es.ies.puerto.model.repository.IItemRepository;
import es.ies.puerto.model.repository.IMobRepository;

public interface IMobController {
    public IItemRepository getIItemRepository();

    public void setIBiomeRepository(IBiomeRepository iBiomeRepository);

    public IBiomeRepository getIBiomeRepository();

    public void setIItemRepository(IItemRepository iItemController);

    public IMobRepository getIMobRepository();

    public void setIMobRepository(IMobRepository mobRepository);

    public List<MobDto> findAll();

    public MobDto findById(Integer id);

    public MobDto save(MobDto mobDto);

    public void deleteById(Integer id);
}
