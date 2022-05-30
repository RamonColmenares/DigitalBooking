package com.example.piG1.model;

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
@Table(name = "imagenes")
public class Imagen {
    @Id
    @SequenceGenerator(name = "imagen_sequence", sequenceName = "imagen_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "imagen_sequence")
    public Integer id;
    @Column(name="nombre")
    public String nombre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Producto producto;
}
