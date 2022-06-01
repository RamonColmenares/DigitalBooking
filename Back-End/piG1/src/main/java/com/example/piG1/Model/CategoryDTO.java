package com.example.piG1.Model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    public Integer id;
    public String title;
    public String description;
    public String urlImage;
    public List<Product> products;
}
