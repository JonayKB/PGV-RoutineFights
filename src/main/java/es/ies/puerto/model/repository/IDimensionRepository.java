package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Dimension;
@Repository
public interface IDimensionRepository extends JpaRepository<Dimension,Integer> {

    List<Dimension> findAll();

    void deleteById(Integer id);

    Optional<Dimension> findById(Integer id);

    Dimension save(Dimension entity);
}
