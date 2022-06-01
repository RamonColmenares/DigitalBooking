package com.example.piG1.Model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeatureDTO {
    public Integer id;
    public String name;
    public String icon;
    public List<Product>products;
}
