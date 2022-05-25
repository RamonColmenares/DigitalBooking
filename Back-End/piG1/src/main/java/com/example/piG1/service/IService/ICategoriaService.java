package com.example.piG1.service.IService;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;

import java.util.List;
import java.util.Set;

public interface ICategoriaService {

    public Categoria crearCategoria(CategoriaDTO categoriaDTO);
    public CategoriaDTO listarCategoria(Integer id);
    public Categoria editarCategoria(CategoriaDTO categoriaDTO);
    public void eliminarCategoria(Integer id);
//    public Set<CategoriaDTO>listarCategorias();
    public List<CategoriaDTO> listarCategorias();

}

