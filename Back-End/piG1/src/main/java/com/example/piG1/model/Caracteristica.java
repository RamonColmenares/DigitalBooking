package com.example.piG1.model;

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
@Table(name = "caracteristicas")
public class Caracteristica {
    @Id
    @SequenceGenerator(name = "caracteristica_sequence", sequenceName = "caracteristica_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracteristica_sequence")
    public Integer id;
    @Column(name="nombre")
    public String nombre;
    @Column(name="descripcion")
    public String descripcion;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Producto> productos = new ArrayList<>();
}
