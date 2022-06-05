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
    private CityDTO city;
    private CategoryDTO category;
}
