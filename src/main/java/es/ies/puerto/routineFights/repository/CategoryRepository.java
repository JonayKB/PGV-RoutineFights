package es.ies.puerto.routineFights.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import es.ies.puerto.routineFights.model.Category;
import es.ies.puerto.routineFights.model.User;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
