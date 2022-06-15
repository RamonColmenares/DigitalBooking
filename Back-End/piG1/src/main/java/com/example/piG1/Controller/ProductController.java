package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.ProductDTO.*;
import com.example.piG1.Model.Entity.Product;
import com.example.piG1.Repository.IProductRepository;
import com.example.piG1.Service.IService.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    IProductServices iProductServices;

    @Autowired
    IProductRepository iProductRepository;

    @GetMapping
    public ResponseEntity<List<GetProductsAllDTO>> findAll() throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findAll());
    }

    @PostMapping
    public ResponseEntity<ProductCompliteDTO> saveComplite (@RequestBody ProductDTO productDTO){
            return ResponseEntity.status(HttpStatus.CREATED).body(iProductServices.saveComplite(productDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        iProductServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductFullDTO>findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findById(id));
    }

    @GetMapping("/allData/{id}")
    public ResponseEntity<ProductCompliteDTO>findByIdComplite(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findByIdComplite(id));
    }

    @GetMapping("/allCity/{id}")
    public ResponseEntity<List<ProductFindByFilterDTO>>findByCityId(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findByCityId(id));
    }

    @GetMapping("/allCategory/{id}")
    public ResponseEntity<List<ProductFindByFilterDTO>>findByCategoryId(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findByCategoryId(id));
    }

    @GetMapping("/findByData")
    public ResponseEntity<List<ProductFindByFilterDTO>>findProductsByData(
            @RequestParam(value = "city", required = false) Set<String> cityName,
            @RequestParam(value = "category", required = false) Set<String> categoryTitle) throws ResourceNotFoundException {
        return ResponseEntity.ok(iProductServices.findByQueryParams(cityName, categoryTitle));
    }
}
