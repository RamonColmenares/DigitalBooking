package com.example.piG1.Model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductCompliteDTO {
    private Integer id;
    private String name;
    private String description;
//    private List<Image> images;
//    private List<Policy> policies;
    private CityDTO city;
    private CategoryDTO category;
//    private List<Feature> features;
}
