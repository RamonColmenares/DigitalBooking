package com.example.piG1.Model.DTO;
import com.example.piG1.Model.Entity.Feature;
import com.example.piG1.Model.Entity.Image;
import com.example.piG1.Model.Entity.Policy;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private List<Image> images;
    private List<Policy> policies;
    private Integer cityId;
    private Integer categoryId;
    private List<Feature> features;
}
