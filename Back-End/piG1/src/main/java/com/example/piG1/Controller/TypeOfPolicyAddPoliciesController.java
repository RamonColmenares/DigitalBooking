package com.example.piG1.Controller;


import com.example.piG1.Model.DTO.TypeOfPolicyDTO.TypeOfPolicyAddPoliciesDTO;
import com.example.piG1.Model.DTO.TypeOfPolicyDTO.TypeOfPolicyDTO;
import com.example.piG1.Service.IService.ITypeOfPolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeOfPolicyAddPolicies")
@CrossOrigin(origins = "*")
public class TypeOfPolicyAddPoliciesController {
    @Autowired
private ITypeOfPolicyServices iTypeOfPolicyServices;

    @PostMapping
    public ResponseEntity<TypeOfPolicyDTO> addPolicies (@RequestBody TypeOfPolicyAddPoliciesDTO typeOfPolicyAddPoliciesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iTypeOfPolicyServices.addPolicies(typeOfPolicyAddPoliciesDTO));
    }
}
