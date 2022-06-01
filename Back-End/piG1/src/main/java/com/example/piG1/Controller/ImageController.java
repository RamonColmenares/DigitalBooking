package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.ImageDTO;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageServices imageServices;

    @GetMapping
    public ResponseEntity<List<ImageDTO>> findAll(){
        return ResponseEntity.ok(imageServices.findAll());
    }

    @PostMapping
    public ResponseEntity<ImageDTO> save(@RequestBody ImageDTO imageDTO){
        if(imageDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(imageServices.save(imageDTO));
        else
            return ResponseEntity.ok(imageServices.save(imageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        imageServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(imageServices.findById(id));
    }
}
