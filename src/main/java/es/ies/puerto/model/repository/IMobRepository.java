package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;

@Repository
public interface IMobRepository extends JpaRepository<Mob, Integer> {

    List<Mob> findAll();

    void deleteById(Integer id);

    Optional<Mob> findById(Integer id);

    Mob save(Mob entity);

    @Modifying
    @Query(value = "DELETE FROM items_mobs WHERE mobs_id = :id", nativeQuery = true)
    void deleteByIdItems(Integer id);

    @Modifying
    @Query(value = "DELETE FROM mobs_biomes WHERE spawn_mobs_id = :id", nativeQuery  = true)
    void deleteByIdBiomes(Integer id);
}
