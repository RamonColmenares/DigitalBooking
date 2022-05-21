package com.example.piG1.service;

import com.example.piG1.model.CategoriaDTO;

import java.util.Set;

public interface ICategoriaService {

    void crearCategoria(CategoriaDTO categoriaDTO);
    CategoriaDTO listarCategoria(Integer id);
    void editarCategoria(CategoriaDTO categoriaDTO);
    void eliminarCategoria(Integer id);
    Set<CategoriaDTO>listarCategorias();

}

