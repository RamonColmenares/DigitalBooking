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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Producto producto;
}
