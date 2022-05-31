package com.example.piG1.Model;

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
@Table(name = "features")
public class Feature {
    @Id
    @SequenceGenerator(name = "feature_sequence", sequenceName = "feature_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_sequence")
    public Integer id;
    @Column(name="name")
    public String name;
    @Column(name="icon")
    public String icon;

    @ManyToMany(mappedBy = "features")
    @JsonIgnore
    private List<Product> products = new ArrayList<>();
}
