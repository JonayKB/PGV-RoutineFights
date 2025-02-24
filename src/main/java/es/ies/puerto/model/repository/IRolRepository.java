package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import es.ies.puerto.model.entity.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Player;
@Repository
public interface IRolRepository extends JpaRepository<Rol,Integer> {

    List<Rol> findAll();

    void deleteById(Integer id);

    Optional<Rol> findById(Integer id);

    Rol save(Rol entity);

    @Modifying
    @Query(value = "UPDATE users SET rol_id = 5 WHERE rol_id = :id", nativeQuery = true)
    void changeToUser(Integer id);

}
