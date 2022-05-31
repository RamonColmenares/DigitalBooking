package com.example.piG1.model;

import lombok.*;

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
}
