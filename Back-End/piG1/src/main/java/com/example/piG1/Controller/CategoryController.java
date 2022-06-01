package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.Category;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Service.CategoryServices;
import com.example.piG1.Service.IService.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class CategoryController {
    @Autowired
    CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        return ResponseEntity.ok(categoryServices.findAll());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
        if(categoryDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryServices.save(categoryDTO));
        else
            return ResponseEntity.ok(categoryServices.save(categoryDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        categoryServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryServices.findById(id));
    }
}
