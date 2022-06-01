package com.example.piG1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "images")
public class Image {
    @Id
    @SequenceGenerator(name = "image_sequence", sequenceName = "image_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
    public Integer id;
    @Column(name="title")
    public String title;
    @Column(name="url")
    public String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    public Product product;
}
