package com.example.piG1.Controller;

import com.example.piG1.Model.DTO.ProductAddFeaturesDTO;
import com.example.piG1.Model.DTO.ProductAddImagesDTO;
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
@RequestMapping("/productAddFeatures")
public class ProductAddFeaturesController {
        @Autowired
        private IProductServices iProductServices;

        @PostMapping
        public ResponseEntity<ProductCompliteDTO> addFeatures(@RequestBody ProductAddFeaturesDTO productAddFeaturesDTO){
            return ResponseEntity.status(HttpStatus.CREATED).body(iProductServices.addFeatures(productAddFeaturesDTO));
        }
}