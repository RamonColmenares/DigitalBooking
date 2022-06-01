package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.Category;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Repository.ICategoryRepository;
import com.example.piG1.Service.IService.ICategoryServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoryServices implements ICategoryServices {
    protected final static Logger logger = Logger.getLogger(CategoryServices.class);

    @Autowired
    public ICategoryRepository categoryRepository ;
    @Autowired
    public CategoryServices categoryServices;

    @Autowired
    ObjectMapper mapper;


    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = mapper.convertValue(categoryDTO, Category.class);
        categoryRepository.save(category);
        if (categoryDTO.getId() == null){
            categoryDTO.setId(category.getId());
            logger.info("Categoria registrada correctamente: "+ categoryDTO);
        }else{
            logger.info("Categoria actualizada correctamente: "+ categoryDTO);
        }
        return categoryDTO;
    }

    @Override
    public CategoryDTO findById(Integer id) throws ResourceNotFoundException {
        Category category = checkId(id);
        CategoryDTO categoryDTO = mapper.convertValue(category, CategoryDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return categoryDTO;
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for(Category category: categories){
            categoriesDTO.add(mapper.convertValue(category, CategoryDTO.class));
        }
        categoriesDTO .sort(Comparator.comparing(CategoryDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ categoriesDTO);
        return categoriesDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        categoryRepository.deleteById(id);
        logger.info("Se elimino la categoria correctamente con el id("+id+")");
    }

    @Override
    public Category checkId(Integer id) throws ResourceNotFoundException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return category.get();
    }
}
