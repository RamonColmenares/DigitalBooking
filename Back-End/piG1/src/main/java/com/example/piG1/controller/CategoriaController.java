package com.example.piG1.controller;

import com.example.piG1.model.Categoria;
import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.service.IService.ICategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    ICategoriaService categoriaService;

    @GetMapping("/{id}")
    public CategoriaDTO listarCategoria(@PathVariable Integer id) {
        return categoriaService.listarCategoria(id);
    }
    @GetMapping
    public List<CategoriaDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }


    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.crearCategoria(categoriaDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> editarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        ResponseEntity<Categoria> response = null;

        if (categoriaDTO.getId() != null && categoriaService.listarCategoria(categoriaDTO.getId()) != null)
            response = ResponseEntity.ok(categoriaService.editarCategoria(categoriaDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (categoriaService.listarCategoria(id) == null) {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            categoriaService.eliminarCategoria(id);
            response = ResponseEntity.ok("SE ELIMINÓ LA CATEGORIA CON ID " + id);
        }
        return response;
    }
}

