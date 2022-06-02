package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.TypeOfPolicyDTO;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.IService.ITypeOfPolicyServices;
import com.example.piG1.Service.TypeOfPolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/typeOfPolicies")
public class TypeOfPolicyController {
    @Autowired
    ITypeOfPolicyServices iTypeOfPolicyServices;

    @GetMapping
    public ResponseEntity<List<TypeOfPolicyDTO>> findAll(){
        return ResponseEntity.ok(iTypeOfPolicyServices.findAll());
    }

    @PostMapping
    public ResponseEntity<TypeOfPolicyDTO> save(@RequestBody TypeOfPolicyDTO typeOfPolicyDTO){
        if(typeOfPolicyDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(iTypeOfPolicyServices.save(typeOfPolicyDTO));
        else
            return ResponseEntity.ok(iTypeOfPolicyServices.save(typeOfPolicyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        iTypeOfPolicyServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeOfPolicyDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iTypeOfPolicyServices.findById(id));
    }
}
