package com.example.piG1.service;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.repository.ICategoriaRepository;
import com.example.piG1.service.IService.ICategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Categoria crearCategoria(CategoriaDTO categoriaDTO) {
        return guardarCategoria(categoriaDTO);
    }

    @Override
    public CategoriaDTO listarCategoria(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        CategoriaDTO categoriaDTO = null;
        if (categoria.isPresent())
            categoriaDTO = mapper.convertValue(categoria, CategoriaDTO.class);
        return categoriaDTO;
    }

    private Categoria guardarCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = mapper.convertValue(categoriaDTO, Categoria.class);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria editarCategoria(CategoriaDTO categoriaDTO) {
        return guardarCategoria(categoriaDTO);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

        @Override
        public List<CategoriaDTO> listarCategorias() {
            List<Categoria> categorias = categoriaRepository.findAll();
            List<CategoriaDTO> categoriasDTO = new ArrayList<>();

            for(Categoria categoria: categorias){
                categoriasDTO.add(mapper.convertValue(categoria, CategoriaDTO.class));
            }
            categoriasDTO .sort(Comparator.comparing(CategoriaDTO::getId)); // aquí suponiendo que tienes un id dentro de tu clase                                                                                                                                             CategoriaDTO
            return categoriasDTO;
        }
}
