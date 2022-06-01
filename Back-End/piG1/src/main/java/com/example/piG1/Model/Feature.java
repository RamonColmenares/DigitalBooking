package com.example.piG1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    public Product product;
}
