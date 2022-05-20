package com.example.piG1.service;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.repository.ICategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//necesito acceder a la capa de DATOS(o sea el repository)
public class CategoriaService implements  ICategoriaService{
    //lo inyecto a traves de inyeccion de dependencias para que lo haga el propio framework
    //es la capa que se encarga de transformar DTO en negocio

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearCategoria(CategoriaDTO categoriaDTO) {
        guardarCategoria(categoriaDTO);
    }

    @Override
    public CategoriaDTO listarCategoria(Integer id) {
       //el metodo me permite traer x cosa mandandole el id
        //pero devuelve objeto de tipo optinal (q me sirve para saber si esta nulo o no)
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        //quiero que me transforme la categoria que cree recien en CategoriaDTO
        CategoriaDTO categoriaDTO = null;
        if (categoria.isPresent())
            categoriaDTO = mapper.convertValue(categoria, CategoriaDTO.class);
        //si es ulo me devuelve nulo, si no, la categoria
        return categoriaDTO;
    }

    private void guardarCategoria(CategoriaDTO categoriaDTO){
        //le paso por parametro el objeto y a que lo quiero convertir
        //el convertValue se encarga de ver que las propiedades las que se llaman igual las asigne
        Categoria categoria = mapper.convertValue(categoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
    }

    @Override
    public void editarCategoria(CategoriaDTO categoriaDTO) {
        guardarCategoria(categoriaDTO);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Set<CategoriaDTO> listarCategorias() {
        //esto me devuelve una lista de categoria
        List<Categoria> categorias = categoriaRepository.findAll();

        Set<CategoriaDTO> categoriasDTO = new HashSet<>();//recorro las categorias y lleno otro Set, y los transformo en categoriasDTO
        for(Categoria categoria: categorias){
            categoriasDTO.add(mapper.convertValue(categoria, CategoriaDTO.class));
        }

        return categoriasDTO;

    }
}
