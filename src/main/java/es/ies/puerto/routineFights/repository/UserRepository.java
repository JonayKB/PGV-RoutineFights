package es.ies.puerto.routineFights.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ies.puerto.routineFights.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
