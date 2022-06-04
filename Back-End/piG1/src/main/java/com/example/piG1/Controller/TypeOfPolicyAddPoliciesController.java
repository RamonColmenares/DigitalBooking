package com.example.piG1.Controller;

import com.example.piG1.Model.DTO.TypeOfPolicyAddPoliciesDTO;
import com.example.piG1.Model.DTO.TypeOfPolicyDTO;
import com.example.piG1.Service.IService.IProductServices;
import com.example.piG1.Service.IService.ITypeOfPolicyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typeOfPolicyAddPolicies")
public class TypeOfPolicyAddPoliciesController {
    @Autowired
private ITypeOfPolicyServices iTypeOfPolicyServices;

    @PostMapping
    public ResponseEntity<TypeOfPolicyDTO> addPolicies (@RequestBody TypeOfPolicyAddPoliciesDTO typeOfPolicyAddPoliciesDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(iTypeOfPolicyServices.addPolicies(typeOfPolicyAddPoliciesDTO));
    }
}
