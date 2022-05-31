package com.example.piG1.service;

import com.example.piG1.model.Category;
import com.example.piG1.model.CategoryDTO;
import com.example.piG1.repository.ICategoryRepository;
import com.example.piG1.service.IService.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoryServices implements ICategoriaService{

    @Autowired
    private ICategoryRepository categoriaRepository;
    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    ObjectMapper mapper;
    private Category guardarCategoria(CategoryDTO categoryDTO){
        Category category = mapper.convertValue(categoryDTO, Category.class);
        return categoriaRepository.save(category);
    }
    @Override
    public Category crearCategoria(CategoryDTO categoryDTO) {
        return guardarCategoria(categoryDTO);
    }

    @Override
    public CategoryDTO listarCategoria(Integer id) {
        Optional<Category> categoria = categoriaRepository.findById(id);
        CategoryDTO categoryDTO = null;
        if (categoria.isPresent())
            categoryDTO = mapper.convertValue(categoria, CategoryDTO.class);
        return categoryDTO;
    }
    @Override
    public Category editarCategoria(CategoryDTO categoryDTO) {
        return guardarCategoria(categoryDTO);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> listarCategorias() {
        List<Category> categories = categoriaRepository.findAll();
        List<CategoryDTO> categoriasDTO = new ArrayList<>();

        for(Category category : categories){
            categoriasDTO.add(mapper.convertValue(category, CategoryDTO.class));
        }
        categoriasDTO .sort(Comparator.comparing(CategoryDTO::getId)); // aquí suponiendo que tienes un id dentro de tu clase                                                                                                                                             CategoryDTO
        return categoriasDTO;
    }
}
