package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import es.ies.puerto.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Item;
import es.ies.puerto.model.entity.Player;
@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    List<User> findAll();

    void deleteById(Integer id);

    Optional<User> findById(Integer id);

    User save(User entity);

}
