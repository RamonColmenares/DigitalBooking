package com.example.piG1.Model.DTO;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityDTO {
    private Integer id;
    private String name;
    private String nameCountry;
//    public List<Product> products;
}
