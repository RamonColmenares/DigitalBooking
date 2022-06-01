package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.CategoryDTO;
import com.example.piG1.Model.PolicyDTO;
import com.example.piG1.Service.IService.ICategoryServices;
import com.example.piG1.Service.PolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    PolicyServices policyServices;

    @GetMapping
    public ResponseEntity<List<PolicyDTO>> findAll(){
        return ResponseEntity.ok(policyServices.findAll());
    }

    @PostMapping
    public ResponseEntity<PolicyDTO> save(@RequestBody PolicyDTO policyDTO){
        if(policyDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(policyServices.save(policyDTO));
        else
            return ResponseEntity.ok(policyServices.save(policyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        policyServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(policyServices.findById(id));
    }
}
