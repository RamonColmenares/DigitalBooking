package com.example.piG1.Model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    public Integer id;
    public String name;
    public String description;
    public Boolean availability;
    private Image image;
    private City city;
    private Category category;
    private Feature feature;
}
