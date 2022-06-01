package com.example.piG1.Model;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityDTO {
    public Integer id;
    public String name;
    public String nameCountry;
    private List<Product> products;
}
