package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.ImageDTO;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.IService.IImageServices;
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
    IImageServices iImageServices;

    @GetMapping
    public ResponseEntity<List<ImageDTO>> findAll(){
        return ResponseEntity.ok(iImageServices.findAll());
    }

    @PostMapping
    public ResponseEntity<ImageDTO> save(@RequestBody ImageDTO imageDTO){
        if(imageDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(iImageServices.save(imageDTO));
        else
            return ResponseEntity.ok(iImageServices.save(imageDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        iImageServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iImageServices.findById(id));
    }
}
