package com.example.piG1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List <Caracteristica> caracteristicas = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Ciudad ciudad;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @JsonIgnore
    private List <Imagen> imagenes = new ArrayList<>();

}
