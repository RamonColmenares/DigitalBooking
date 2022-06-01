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
    public List<Image> images;
    public List<Policy> policies;
    public City city;
    public Category category;
    public List<Feature> features;
    public List<Booking> bookings;
}
