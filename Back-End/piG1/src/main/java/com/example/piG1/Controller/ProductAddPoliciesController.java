package com.example.piG1.Controller;

import com.example.piG1.Model.DTO.ProductDTO.ProductAddPoliciesDTO;
import com.example.piG1.Model.DTO.ProductDTO.ProductCompliteDTO;
import com.example.piG1.Service.IService.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productAddPolicies")
@CrossOrigin(origins = "*")
public class ProductAddPoliciesController {
    @Autowired
    private IProductServices iProductServices;

    @PostMapping
    public ResponseEntity<ProductCompliteDTO> addPolicies(@RequestBody ProductAddPoliciesDTO productAddPoliciesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductServices.addPolicies(productAddPoliciesDTO));
    }
}
