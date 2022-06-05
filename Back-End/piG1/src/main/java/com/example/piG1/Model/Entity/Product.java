package com.example.piG1.Model.Entity;

import com.example.piG1.Model.Entity.Category;
import com.example.piG1.Model.Entity.City;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "products")
public class Product {
//    @Id
//    @SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(name="name")
    public String name;
    @Column(name="description")
    public String description;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public Category category;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public City city;

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List <Feature> features = new ArrayList<>();

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List <Image> images = new ArrayList<>();

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List <Policy> policies = new ArrayList<>();

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List <Booking> bookings = new ArrayList<>();
}
