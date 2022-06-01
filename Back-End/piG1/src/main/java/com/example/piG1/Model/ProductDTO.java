package com.example.piG1.Model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    public Integer id;
    public String name;
    public String description;
    private List<Image> images;
    private List<Policy> policies;
    private City city;
    private Category category;
    private List<Feature> features;
    private List<Booking> bookings;
}
