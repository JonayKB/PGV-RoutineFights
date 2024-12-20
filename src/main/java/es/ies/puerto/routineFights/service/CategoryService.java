package es.ies.puerto.routineFights.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.ies.puerto.routineFights.api.dto.CategoryDTO;
import es.ies.puerto.routineFights.api.dto.UserDTO;
import es.ies.puerto.routineFights.api.mappers.CategoryMapper;
import es.ies.puerto.routineFights.api.mappers.UserMapper;
import es.ies.puerto.routineFights.model.Category;
import es.ies.puerto.routineFights.model.User;
import es.ies.puerto.routineFights.repository.CategoryRepository;
import es.ies.puerto.routineFights.repository.UserRepository;
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Set<CategoryDTO> findAll(){
        List<Category> categories = categoryRepository.findAll();
        Set<CategoryDTO> categoriesDTOs = new HashSet<>();
        for (Category category : categories) {
            categoriesDTOs.add(CategoryMapper.INSTANCE.toDto(category));
        }
        return categoriesDTOs;
    }
    public CategoryDTO findById(int id){
        Category category = categoryRepository.findById(id).orElse(null);
        return CategoryMapper.INSTANCE.toDto(category);
    }
    public CategoryDTO save(CategoryDTO categoryDTO){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDTO);
        return CategoryMapper.INSTANCE.toDto(categoryRepository.save(category));
    }
    public void deleteById(int id){
        categoryRepository.deleteById(id);
    }

}
