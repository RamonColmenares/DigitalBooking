package com.example.piG1.Model.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="description")
    public String description;
    @Column(name="urlImage")
    public String urlImage;

//    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @JsonIgnore
//    public List<Product> products = new ArrayList<>();
}
