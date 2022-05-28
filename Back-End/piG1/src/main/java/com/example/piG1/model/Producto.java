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
@Table(name = "productos")
public class Producto {
    @Id
    @SequenceGenerator(name = "producto_sequence", sequenceName = "producto_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_sequence")
    public Integer id;
    @Column(name="nombre")
    public String nombre;
    @Column(name="descripcion")
    public String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Categoria categoria;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable
            (name="productos_caracteristicas",
                    joinColumns={@JoinColumn(name="producto_id")},
                    inverseJoinColumns={@JoinColumn(name="caracteristicas_id")}
            )
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List <Caracteristica> caracteristicas = new ArrayList<>();
}
