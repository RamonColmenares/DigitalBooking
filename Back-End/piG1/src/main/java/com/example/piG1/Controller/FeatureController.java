package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.FeatureDTO;
import com.example.piG1.Service.FeatureServices;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.IService.IFeatureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/feature")
public class FeatureController {
    @Autowired
    FeatureServices featureServices;

    @GetMapping
    public ResponseEntity<List<FeatureDTO>> findAll(){
        return ResponseEntity.ok(featureServices.findAll());
    }

    @PostMapping
    public ResponseEntity<FeatureDTO> save(@RequestBody FeatureDTO featureDTO){
        if(featureDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(featureServices.save(featureDTO));
        else
            return ResponseEntity.ok(featureServices.save(featureDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        featureServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(featureServices.findById(id));
    }
}
