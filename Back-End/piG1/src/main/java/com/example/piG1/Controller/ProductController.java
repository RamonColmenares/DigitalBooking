package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.ProductDTO;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(productServices.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        if(productDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(productServices.save(productDTO));
        else
            return ResponseEntity.ok(productServices.save(productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        productServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productServices.findById(id));
    }
}
