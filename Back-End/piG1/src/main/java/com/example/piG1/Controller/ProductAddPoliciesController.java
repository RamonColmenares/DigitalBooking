package com.example.piG1.Controller;

import com.example.piG1.Model.DTO.ProductAddPoliciesDTO;
import com.example.piG1.Model.DTO.ProductCompliteDTO;
import com.example.piG1.Service.IService.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/productAddPolicies")
public class ProductAddPoliciesController {
    @Autowired
    private IProductServices iProductServices;

    @PostMapping
    public ResponseEntity<ProductCompliteDTO> addPolicies(@RequestBody ProductAddPoliciesDTO productAddPoliciesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductServices.addPolicies(productAddPoliciesDTO));
    }
}
