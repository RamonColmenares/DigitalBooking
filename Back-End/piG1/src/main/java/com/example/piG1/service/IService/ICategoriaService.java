package com.example.piG1.service.IService;

import com.example.piG1.model.Category;
import com.example.piG1.model.CategoryDTO;

import java.util.List;

public interface ICategoriaService {

    public Category crearCategoria(CategoryDTO categoryDTO);
    public CategoryDTO listarCategoria(Integer id);
    public Category editarCategoria(CategoryDTO categoryDTO);
    public void eliminarCategoria(Integer id);
//    public Set<CategoryDTO>listarCategorias();
    public List<CategoryDTO> listarCategorias();

}

