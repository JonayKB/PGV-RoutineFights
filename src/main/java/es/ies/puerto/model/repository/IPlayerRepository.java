package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Player;
@Repository
public interface IPlayerRepository extends JpaRepository<Player,Integer> {

    List<Player> findAll();

    void deleteById(Integer id);

    Optional<Player> findById(Integer id);

    Player save(Player entity);

}
