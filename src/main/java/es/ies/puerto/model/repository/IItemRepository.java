package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Mob;
import es.ies.puerto.model.entity.Player;
@Repository
public interface IItemRepository extends JpaRepository<Item,Integer> {

    List<Item> findAll();

    void deleteById(Integer id);

    Optional<Item> findById(Integer id);

    Item save(Item entity);

}
