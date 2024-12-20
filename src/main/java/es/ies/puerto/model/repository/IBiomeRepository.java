package es.ies.puerto.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.model.entity.Biome;
@Repository
public interface IBiomeRepository extends JpaRepository<Biome,Integer> {

    List<Biome> findAll();

    void deleteById(Integer id);

    Optional<Biome> findById(Integer id);

    Biome save(Biome entity);
}
