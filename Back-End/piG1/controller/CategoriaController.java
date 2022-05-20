package com.example.piG1.controller;

import com.example.piG1.model.CategoriaDTO;
import com.example.piG1.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
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

}
