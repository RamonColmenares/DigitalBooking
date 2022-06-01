package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.CityDTO;
import com.example.piG1.Service.CityServices;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.IService.ICityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    CityServices cityServices;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        return ResponseEntity.ok(cityServices.findAll());
    }

    @PostMapping
    public ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO){
        if(cityDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(cityServices.save(cityDTO));
        else
            return ResponseEntity.ok(cityServices.save(cityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        cityServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(cityServices.findById(id));
    }
}
