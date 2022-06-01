package com.example.piG1.Model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    private Integer id;
    private String title;
    private String description;
    private String urlImage;
    private List<Product> products;
}
