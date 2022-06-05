package com.example.piG1.Model.DTO.ProductDTO;

import com.example.piG1.Model.DTO.FeatureDTO.FeatureDTO;
import com.example.piG1.Model.DTO.ImageDTO.ImageDTO;
import com.example.piG1.Model.DTO.PolicyDTO.PolicyDTO;
import com.example.piG1.Model.Entity.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductFullDTO {
    private Integer id;
    private String name;
    private String description;
    private List<ImageDTO> images;
    private List<PolicyDTO> policies;
    private City city;
    private Category category;
    private List<FeatureDTO> features;
}
