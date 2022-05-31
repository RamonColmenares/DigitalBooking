package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.Category;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Repository.ICategoryRepository;
import com.example.piG1.Service.IService.ICategoryServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoryServices implements ICategoryServices {

    @Autowired
    private ICategoryRepository categoryRepository ;
    @Autowired
    private CategoryServices categoryServices;

    @Autowired
    ObjectMapper mapper;


    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {

    }
}
