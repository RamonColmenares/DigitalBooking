package com.example.piG1.Controller;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.PolicyDTO.PolicyDTO;
import com.example.piG1.Service.IService.IPolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/policies")
@CrossOrigin(origins = "*")
public class PolicyController {
    @Autowired
    IPolicyServices iPolicyServices;

    @GetMapping
    public ResponseEntity<List<PolicyDTO>> findAll(){
        return ResponseEntity.ok(iPolicyServices.findAll());
    }

    @PostMapping
    public ResponseEntity<PolicyDTO> save(@RequestBody PolicyDTO policyDTO){
        if(policyDTO.getId() == null)
            return ResponseEntity.status(HttpStatus.CREATED).body(iPolicyServices.save(policyDTO));
        else
            return ResponseEntity.ok(iPolicyServices.save(policyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ResourceNotFoundException {
        iPolicyServices.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyDTO> findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iPolicyServices.findById(id));
    }
}
