package com.example.piG1.controller;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.service.IService.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    //se va a comunicar con la capa de servicio

    @Autowired
    ICategoriaService categoriaService;
    //hago la instancia con inyeccion de dependencias

    //ahora hago los metodos que necesito en categoria

    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDTO categoriaDTO){
        categoriaService.crearCategoria(categoriaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public CategoriaDTO listarCategoria(@PathVariable Integer id){
        return categoriaService.listarCategoria(id);
    }

    @PutMapping
    public ResponseEntity<?> editarCategoria(@RequestBody CategoriaDTO categoriaDTO)
    {
        ResponseEntity<Categoria> response = null;

        if (categoriaDTO.getId() != null && categoriaService.listarCategoria(categoriaDTO.getId()) != null)
            response = ResponseEntity.ok(categoriaService.editarCategoria(categoriaDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id)
    {
        ResponseEntity response = null;
        if(categoriaService.listarCategoria(id) == null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            categoriaService.eliminarCategoria(id);
            response= ResponseEntity.ok("SE ELIMINÓ LA CATEGORIA CON ID " + id);
        }
        return response;
    };
    @GetMapping
    public Set<CategoriaDTO> listarCategorias()
    {
        return categoriaService.listarCategorias();
    }
}
